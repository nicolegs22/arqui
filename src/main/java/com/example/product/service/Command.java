package com.example.product.service;

import com.example.product.model.ProductDto;
import org.springframework.http.ResponseEntity;

public interface Command<P, S> {
    ResponseEntity<String> execute(ProductDto input);
}
