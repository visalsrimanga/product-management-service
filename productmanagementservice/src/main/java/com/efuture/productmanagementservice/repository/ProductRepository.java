package com.efuture.productmanagementservice.repository;

import com.efuture.productmanagementservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
