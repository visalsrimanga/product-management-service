package com.efuture.productmanagementservice.repository;

import com.efuture.productmanagementservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

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

    @Query(
            nativeQuery = true,
            value = "select\n" +
                    "    p.name,\n" +
                    "    p.description,\n" +
                    "    p.price,\n" +
                    "    pc.name as product_category,\n" +
                    "    GROUP_CONCAT(pcmt.comment order by pcmt.created_at asc separator ';') as product_comments\n" +
                    "from product p\n" +
                    "inner join product_category pc on pc.product_category_id = p.product_category_id\n" +
                    "left join product_comment pcmt on pcmt.product_id = p.product_id\n" +
                    "where pc.name = :productCategory\n" +
                    "group by\n" +
                    "p.product_id, p.name, p.description, p.price, pc.name"
    )
    List<Object[]> getProductListByCategory(String productCategory);

    @Query(
            nativeQuery = true,
            value = "select\n" +
                    "    p.name,\n" +
                    "    p.description,\n" +
                    "    p.price,\n" +
                    "    pc.name as product_category,\n" +
                    "    GROUP_CONCAT(pcmt.comment order by pcmt.created_at asc separator ';') as product_comments\n" +
                    "from product p\n" +
                    "inner join product_category pc on pc.product_category_id = p.product_category_id\n" +
                    "left join product_comment pcmt on pcmt.product_id = p.product_id\n" +
                    "where p.price >= :premiumProductMinPrice\n" +
                    "group by\n" +
                    "p.product_id, p.name, p.description, p.price, pc.name"
    )
    List<Object[]> getPremiumProducts(BigDecimal premiumProductMinPrice);
}
