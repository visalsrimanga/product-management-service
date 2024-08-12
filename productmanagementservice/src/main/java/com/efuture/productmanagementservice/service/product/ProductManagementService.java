package com.efuture.productmanagementservice.service.product;

import com.efuture.productmanagementservice.dto.product.CommonResponse;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.dto.product.RetrieveProductResponse;
import com.efuture.productmanagementservice.dto.product.UpdateProductRequest;
import com.efuture.productmanagementservice.serviceinterface.product.ProductManagementInterface;
import com.efuture.productmanagementservice.util.constant.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ProductManagementService implements ProductManagementInterface {

    @Override
    @Transactional
    public ResponseEntity<CommonResponse> createProduct(CreateProductRequest createProductRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse(Constants.SUCCESS));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(Constants.ERROR));
        }
    }

    @Override
    @Transactional
    public ResponseEntity<CommonResponse> updateProduct(UpdateProductRequest updateProductRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("success"));
    }

    @Override
    @Transactional
    public ResponseEntity<CommonResponse> deleteProduct(String productId) {
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("success"));
    }

    @Override
    public ResponseEntity<RetrieveProductResponse> getProductsByCategory(String productCategory) {
        return null;
    }

    @Override
    public ResponseEntity<RetrieveProductResponse> getPremiumProducts(String price) {
        return null;
    }

}
