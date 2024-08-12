package com.efuture.productmanagementservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "product_comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCommentId;

    private String comment;
    @CreationTimestamp
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
