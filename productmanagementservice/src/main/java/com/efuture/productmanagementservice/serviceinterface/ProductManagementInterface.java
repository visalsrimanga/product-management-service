package com.efuture.productmanagementservice.serviceinterface;

import com.efuture.productmanagementservice.dto.CommonResponse;
import com.efuture.productmanagementservice.dto.CreateProductRequest;
import com.efuture.productmanagementservice.dto.RetrieveProductResponse;
import com.efuture.productmanagementservice.dto.UpdateProductRequest;
import org.springframework.http.ResponseEntity;


public interface ProductManagementInterface {
    ResponseEntity<CommonResponse> createProduct(CreateProductRequest createProductRequest);

    ResponseEntity<CommonResponse> updateProduct(UpdateProductRequest updateProductRequest);

    ResponseEntity<CommonResponse> deleteProduct(String productId);

    ResponseEntity<RetrieveProductResponse> getProductsByCategory(String productCategory);

    ResponseEntity<RetrieveProductResponse> getPremiumProducts();
}
