package com.efuture.productmanagementservice.repository;

import com.efuture.productmanagementservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "update product\n" +
                    "set name = :name, description = :description, price = :price\n" +
                    "where product_id = :productId"
    )
    void updateProduct(Integer productId, String name, String description, BigDecimal price);

    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "update product\n" +
                    "set status = 'D'\n" +
                    "where product_id = :productId"
    )
    void deleteProduct(String productId);
}
