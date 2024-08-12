package com.efuture.productmanagementservice.repository;

import com.efuture.productmanagementservice.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {
}
