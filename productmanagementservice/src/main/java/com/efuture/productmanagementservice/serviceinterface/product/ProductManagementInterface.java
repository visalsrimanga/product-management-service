package com.efuture.productmanagementservice.serviceinterface.product;

import com.efuture.productmanagementservice.dto.product.CommonResponse;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.dto.product.RetrieveProductResponse;
import com.efuture.productmanagementservice.dto.product.UpdateProductRequest;
import org.springframework.http.ResponseEntity;


public interface ProductManagementInterface {
    ResponseEntity<CommonResponse> createProduct(CreateProductRequest createProductRequest);

    ResponseEntity<CommonResponse> updateProduct(UpdateProductRequest updateProductRequest);

    ResponseEntity<CommonResponse> deleteProduct(String productId);

    ResponseEntity<RetrieveProductResponse> getProductsByCategory(String productCategory);

    ResponseEntity<RetrieveProductResponse> getPremiumProducts(String price);
}
