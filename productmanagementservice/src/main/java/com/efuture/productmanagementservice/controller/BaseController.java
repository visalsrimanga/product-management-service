package com.efuture.productmanagementservice.controller;

import com.efuture.productmanagementservice.dto.common.CommonAdaptorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public <T>ResponseEntity<CommonAdaptorResp<T>> setResponseEntity(CommonAdaptorResp<T> commonAdaptorResp){
        String resultCode=commonAdaptorResp.getResult().getResultCode();
        switch (resultCode){
            case "00":
            case "05":
            case "100":
            case "000":
                return ResponseEntity.status(HttpStatus.OK).body(commonAdaptorResp);
            case "30":
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(commonAdaptorResp);
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(commonAdaptorResp);
        }
    }

}
