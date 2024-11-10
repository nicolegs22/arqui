package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product save(Product product);

    Optional<Product> findById(Integer id);
}
