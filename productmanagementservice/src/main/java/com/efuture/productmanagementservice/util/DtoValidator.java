package com.efuture.productmanagementservice.util;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DtoValidator {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    protected Validator validator = factory.getValidator();

    public <T> void validateRequestDto(T dtoObject) throws BaseException {
        Set<ConstraintViolation<T>> constraintViolationSet = validator.validate(dtoObject);
        ConstraintViolation<T> firstViolation = constraintViolationSet.stream().findFirst().orElse(null);
        if (firstViolation != null) {
            throw new BaseException(firstViolation.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
