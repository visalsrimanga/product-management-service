package com.efuture.productmanagementservice.serviceinterface.product;

import com.efuture.productmanagementservice.dto.common.CommonAdaptorResp;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.util.exception.BaseException;

public interface ProductManagementInterface {
    CommonAdaptorResp<String> createNewProduct(CreateProductRequest createProductRequest) throws BaseException;
}
