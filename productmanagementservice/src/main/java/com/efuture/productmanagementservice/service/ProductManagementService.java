package com.efuture.productmanagementservice.service;

import com.efuture.productmanagementservice.dto.ProductData;
import com.efuture.productmanagementservice.dto.CommonResponse;
import com.efuture.productmanagementservice.dto.CreateProductRequest;
import com.efuture.productmanagementservice.dto.RetrieveProductResponse;
import com.efuture.productmanagementservice.dto.UpdateProductRequest;
import com.efuture.productmanagementservice.mapper.ProductManagementMapper;
import com.efuture.productmanagementservice.model.ProductCategory;
import com.efuture.productmanagementservice.repository.ProductCategoryRepository;
import com.efuture.productmanagementservice.repository.ProductRepository;
import com.efuture.productmanagementservice.serviceinterface.ProductManagementInterface;
import com.efuture.productmanagementservice.util.BaseException;
import com.efuture.productmanagementservice.util.DtoValidator;
import com.efuture.productmanagementservice.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductManagementService implements ProductManagementInterface {
    @Autowired
    ProductManagementMapper productManagementMapper;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    DtoValidator dtoValidator;
    @Value("${premium.product.min.price}")
    private BigDecimal premiumProductMinPrice;


    @Override
    @Transactional
    public ResponseEntity<CommonResponse> createProduct(CreateProductRequest createProductRequest) {
        try {
            dtoValidator.validateRequestDto(createProductRequest);
            ProductCategory productCategory = productCategoryRepository.findProductCategory(createProductRequest.getCategory());
            if (productCategory == null){
                ProductCategory productCategoryNew = new ProductCategory();
                productCategoryNew.setName(createProductRequest.getCategory());
                productCategory = productCategoryRepository.save(productCategoryNew);
            }
            productRepository.save(productManagementMapper.mapProduct(createProductRequest, productCategory));
            return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse(Constants.SUCCESS));
        } catch (BaseException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse(Constants.VALIDATION_FAILURE, ex.getMessage()));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(Constants.ERROR));
        }
    }

    @Override
    @Transactional
    public ResponseEntity<CommonResponse> updateProduct(UpdateProductRequest updateProductRequest) {
        try{
            dtoValidator.validateRequestDto(updateProductRequest);
            productRepository.updateProduct(updateProductRequest.getProductId(), updateProductRequest.getName(), updateProductRequest.getDescription(), updateProductRequest.getPrice());
            return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse(Constants.SUCCESS));
        } catch (BaseException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse(Constants.VALIDATION_FAILURE, ex.getMessage()));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(Constants.ERROR));
        }
    }

    @Override
    @Transactional
    public ResponseEntity<CommonResponse> deleteProduct(String productId) {
        try{
            if(productId == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CommonResponse(Constants.VALIDATION_FAILURE, "productId cannot be null"));
            productRepository.deleteProduct(productId);
            return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse(Constants.SUCCESS));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(Constants.ERROR));
        }
    }

    @Override
    public ResponseEntity<RetrieveProductResponse> getProductsByCategory(String productCategory) {
        try{
            if (productCategory == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RetrieveProductResponse(null, Constants.VALIDATION_FAILURE));
            List<Object[]> results = productRepository.getProductListByCategory(productCategory);
            List<ProductData> productDataList = results.stream().map(this::mapToProductData).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(new RetrieveProductResponse(productDataList, Constants.SUCCESS));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RetrieveProductResponse(new ArrayList<>(), Constants.ERROR));
        }
    }

    private ProductData mapToProductData(Object[] result) {
        return new ProductData(
                (String) result[0],
                (String) result[1],
                (BigDecimal) result[2],
                (String) result[3],
                result[4] == null ? new ArrayList<>() : Arrays.asList(((String) result[4]).split(";"))
        );
    }

    @Override
    public ResponseEntity<RetrieveProductResponse> getPremiumProducts() {
        try{
            List<Object[]> results = productRepository.getPremiumProducts(premiumProductMinPrice);
            List<ProductData> productDataList = results.stream().map(this::mapToProductData).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(new RetrieveProductResponse(productDataList, Constants.SUCCESS));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RetrieveProductResponse(new ArrayList<>(), Constants.ERROR));
        }
    }

}
