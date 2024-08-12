package com.efuture.productmanagementservice.controller.product;

import com.efuture.productmanagementservice.controller.BaseController;
import com.efuture.productmanagementservice.dto.common.CommonAdaptorResp;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.serviceinterface.product.ProductManagementInterface;
import com.efuture.productmanagementservice.util.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pms/product")
public class ProductManagementController extends BaseController {
    @Autowired
    ProductManagementInterface productManagementInterface;

    @PostMapping()
    public ResponseEntity<CommonAdaptorResp<String>> createNewProduct(@Valid @RequestBody CreateProductRequest createProductRequest, HttpServletRequest httpServletRequest) throws BaseException {
        CommonAdaptorResp<String> adaptorResp = productManagementInterface.createNewProduct(createProductRequest);
        return setResponseEntity(adaptorResp);
    }
}
