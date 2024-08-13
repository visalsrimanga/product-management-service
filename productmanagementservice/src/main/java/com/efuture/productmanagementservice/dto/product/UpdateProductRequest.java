package com.efuture.productmanagementservice.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
}
