package com.efuture.productmanagementservice.mapper;

import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.model.Product;
import com.efuture.productmanagementservice.model.ProductCategory;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class ProductManagementMapper {
    public Product mapProduct(CreateProductRequest createProductRequest, ProductCategory productCategory) {
        Product product = new Product();
        product.setName(createProductRequest.getName());
        product.setDescription(createProductRequest.getDescription());
        product.setPrice(createProductRequest.getPrice());
        product.setProductCategory(productCategory);
        product.setLaunchDate(Date.valueOf(LocalDate.now()));
        return product;
    }
}
