package com.efuture.productmanagementservice.serviceinterface.product;

import com.efuture.productmanagementservice.dto.product.CommonResponse;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.dto.product.UpdateProductRequest;
import com.efuture.productmanagementservice.util.exception.BaseException;
import org.springframework.http.ResponseEntity;

public interface ProductManagementInterface {
    ResponseEntity<CommonResponse> createProduct(CreateProductRequest createProductRequest) throws BaseException;

    ResponseEntity<CommonResponse> updateProduct(UpdateProductRequest updateProductRequest) throws BaseException;

    ResponseEntity<CommonResponse> deleteProduct(String productId) throws BaseException;

    ResponseEntity<CommonResponse> getProductsByCategory(String productCategory) throws BaseException;

    ResponseEntity<CommonResponse> getPremiumProducts(String price) throws BaseException;
}
