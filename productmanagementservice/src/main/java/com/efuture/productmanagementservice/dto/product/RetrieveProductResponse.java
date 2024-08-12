package com.efuture.productmanagementservice.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveProductResponse {
    List<ProductData> result;
    private String status;
}
