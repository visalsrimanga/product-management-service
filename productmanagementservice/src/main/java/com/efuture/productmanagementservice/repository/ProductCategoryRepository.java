package com.efuture.productmanagementservice.repository;

import com.efuture.productmanagementservice.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
