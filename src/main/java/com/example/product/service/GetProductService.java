package com.example.product.service; // Asegúrate de que este es el paquete correcto

import com.example.product.model.ProductDto; // Asegúrate de que la ruta del paquete es correcta
import com.example.product.exception.ProductNotFoundException;
import com.example.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional; // Asegúrate de importar Optional

@Service
public class GetProductService implements Query<Integer, ProductDto> {

    private final IProductRepository iProductRepository;

    // Constructor para inyectar el repositorio de productos
    public GetProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public ResponseEntity<ProductDto> execute(Integer id) {
        Optional<Product> product = this.iProductRepository.findById(id);
        if (product.isPresent()) {
            // Asegúrate de que el constructor de ProductDto acepte un Product
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ProductDto(product.get()) // Se utiliza el Product obtenido
            );
        }
        throw new ProductNotFoundException();
    }
}
