package com.example.product.service;

import com.example.product.exception.ProductBadRequestException;
import com.example.product.model.ProductDto;
import io.micrometer.common.util.StringUtils;
import com.example.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<ProductDto, String> {

    private final IProductRepository iProductRepository;

    public CreateProductService(IProductRepository iProductRepository){
        this.iProductRepository = iProductRepository;
    }

    @Override
    public ResponseEntity<String> execute(ProductDto input){

        Product product = input.toProduct();

        // Corregido: cerrar correctamente los paréntesis en el if
        if (StringUtils.isEmpty(product.getName())) {
            // Corregido: cerrar correctamente los paréntesis en la excepción
            throw new ProductBadRequestException("Name is required.");
        }

        int id = Math.toIntExact(iProductRepository.save(product).getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Product %d, created", id));
    }
}
