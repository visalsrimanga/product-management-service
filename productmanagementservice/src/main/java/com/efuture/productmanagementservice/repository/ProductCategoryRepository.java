package com.efuture.productmanagementservice.repository;

import com.efuture.productmanagementservice.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    @Query(
            nativeQuery = true,
            value = "select *\n" +
                    "from product_category pc\n" +
                    "where pc.name = :category"
    )
    ProductCategory findProductCategory(String category);
}
