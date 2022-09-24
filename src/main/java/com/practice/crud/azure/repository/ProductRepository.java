package com.practice.crud.azure.repository;

import com.practice.crud.azure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
