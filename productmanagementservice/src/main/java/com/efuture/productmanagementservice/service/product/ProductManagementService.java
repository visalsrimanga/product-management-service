package com.efuture.productmanagementservice.service.product;

import com.efuture.productmanagementservice.dto.product.CommonResponse;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.dto.product.UpdateProductRequest;
import com.efuture.productmanagementservice.serviceinterface.product.ProductManagementInterface;
import com.efuture.productmanagementservice.util.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ProductManagementService implements ProductManagementInterface {
    @Override
    public ResponseEntity<CommonResponse> createProduct(CreateProductRequest createProductRequest) throws BaseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse("Created Product Successfully"));
    }

    @Override
    public ResponseEntity<CommonResponse> updateProduct(UpdateProductRequest updateProductRequest) throws BaseException {
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("Updated Product Successfully"));
    }

    @Override
    public ResponseEntity<CommonResponse> deleteProduct(String productId) throws BaseException {
        return null;
    }

    @Override
    public ResponseEntity<CommonResponse> getProductsByCategory(String productCategory) throws BaseException {
        return null;
    }

    @Override
    public ResponseEntity<CommonResponse> getPremiumProducts(String price) throws BaseException {
        return null;
    }
}
