package com.efuture.productmanagementservice.controller.product;

import com.efuture.productmanagementservice.controller.BaseController;
import com.efuture.productmanagementservice.dto.product.CommonResponse;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.dto.product.UpdateProductRequest;
import com.efuture.productmanagementservice.serviceinterface.product.ProductManagementInterface;
import com.efuture.productmanagementservice.util.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pms/product")
public class ProductManagementController extends BaseController {
    @Autowired
    ProductManagementInterface productManagementInterface;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest, HttpServletRequest httpServletRequest) throws BaseException {
        return productManagementInterface.createProduct(createProductRequest);
    }

    @PatchMapping("/update")
    public ResponseEntity<CommonResponse> updateProduct(@Valid @RequestBody UpdateProductRequest updateProductRequest, HttpServletRequest httpServletRequest) throws BaseException {
        return productManagementInterface.updateProduct(updateProductRequest);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<CommonResponse> deleteProduct(@PathVariable String productId, HttpServletRequest httpServletRequest) throws BaseException {
        return productManagementInterface.deleteProduct(productId);
    }

    @GetMapping("/get-product-by-category")
    public ResponseEntity<CommonResponse> getProductsByCategory(@RequestParam String productCategory, HttpServletRequest httpServletRequest) throws BaseException {
        return productManagementInterface.getProductsByCategory(productCategory);
    }

    @GetMapping("/get-premium-product")
    public ResponseEntity<CommonResponse> getPremiumProducts(@RequestParam String price, HttpServletRequest httpServletRequest) throws BaseException {
        return productManagementInterface.getPremiumProducts(price);
    }
}
