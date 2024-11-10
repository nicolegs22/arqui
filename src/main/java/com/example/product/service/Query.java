package com.example.product.service;

import com.example.product.model.ProductDto;
import org.springframework.http.ResponseEntity;

public interface Query<I extends Number, P> {
    ResponseEntity<ProductDto> execute(Integer id);
}
