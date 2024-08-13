package com.efuture.productmanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {
    private String name;
    private String description;
    private BigDecimal price;
    private String productCategory;
    private List<String> productComments;
}
