package com.efuture.productmanagementservice.service.product;

import com.efuture.productmanagementservice.dto.product.CommonResponse;
import com.efuture.productmanagementservice.dto.product.CreateProductRequest;
import com.efuture.productmanagementservice.dto.product.RetrieveProductResponse;
import com.efuture.productmanagementservice.dto.product.UpdateProductRequest;
import com.efuture.productmanagementservice.mapper.ProductManagementMapper;
import com.efuture.productmanagementservice.model.ProductCategory;
import com.efuture.productmanagementservice.repository.ProductCategoryRepository;
import com.efuture.productmanagementservice.repository.ProductRepository;
import com.efuture.productmanagementservice.serviceinterface.product.ProductManagementInterface;
import com.efuture.productmanagementservice.util.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ProductManagementService implements ProductManagementInterface {
    @Autowired
    ProductManagementMapper productManagementMapper;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    @Transactional
    public ResponseEntity<CommonResponse> createProduct(CreateProductRequest createProductRequest) {
        try {
            ProductCategory productCategory = productCategoryRepository.findProductCategory(createProductRequest.getCategory());
            if (productCategory == null){
                ProductCategory productCategoryNew = new ProductCategory();
                productCategoryNew.setName(createProductRequest.getCategory());
                productCategory = productCategoryRepository.save(productCategoryNew);
            }
            productRepository.save(productManagementMapper.mapProduct(createProductRequest, productCategory));
            return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse(Constants.SUCCESS));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(Constants.ERROR));
        }
    }

    @Override
    @Transactional
    public ResponseEntity<CommonResponse> updateProduct(UpdateProductRequest updateProductRequest) {
        try{
//            Product product = new Product();
//            product.setProductId(updateProductRequest.getProductId());
//            product.setName(updateProductRequest.getName());
//            product.setDescription(updateProductRequest.getDescription());
//            product.setPrice(updateProductRequest.getPrice());
//            productRepository.save(product);
            productRepository.updateProduct(updateProductRequest.getProductId(), updateProductRequest.getName(), updateProductRequest.getDescription(), updateProductRequest.getPrice());
            return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("success"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CommonResponse(Constants.ERROR));
        }

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
