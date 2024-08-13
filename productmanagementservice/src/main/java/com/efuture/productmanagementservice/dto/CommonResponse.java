package com.efuture.productmanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {
    private String status;
    private String message;

    public CommonResponse(String status){
        this.status = status;
    }
}
