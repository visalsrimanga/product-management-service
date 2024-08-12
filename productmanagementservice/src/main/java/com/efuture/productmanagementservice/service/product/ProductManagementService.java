package com.efuture.productmanagementservice.service.product;

import com.efuture.productmanagementservice.dto.common.CommonAdaptorResp;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.serviceinterface.product.ProductManagementInterface;
import com.efuture.productmanagementservice.util.exception.BaseException;

public class ProductManagementService implements ProductManagementInterface {
    @Override
    public CommonAdaptorResp<String> createNewProduct(CreateProductRequest createProductRequest) throws BaseException {
        return null;
    }
}
