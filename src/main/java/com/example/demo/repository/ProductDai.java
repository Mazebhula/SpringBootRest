package com.example.demo.repository;

import com.example.demo.model.Product;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDai extends JpaRepository<Product, Integer> {
}
