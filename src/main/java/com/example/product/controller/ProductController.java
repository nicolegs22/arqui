package com.example.product.controller;


import com.example.product.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private Map<Long, String> products = new HashMap<>(); // Simulando una base de datos en memoria

    @PostMapping
    public ResponseEntity<String> create(@RequestBody String product) {
        long id = products.size() + 1; // Simulando un ID
        products.put(id, product);
        return new ResponseEntity<>("Product Created with ID: " + id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> obtain(@PathVariable Long id) {
        String product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException(); // Lanzar excepción si no se encuentra
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException(); // Lanzar excepción si no se encuentra
        }
        products.remove(id);
        return new ResponseEntity<>("Product Deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody String product) {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException(); // Lanzar excepción si no se encuentra
        }
        products.put(id, product);
        return new ResponseEntity<>("Product Updated", HttpStatus.OK);
    }
}
