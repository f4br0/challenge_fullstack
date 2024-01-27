package com.reto.application.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException {

    private final HttpStatusCode code;

    public BusinessException(HttpStatus httpStatus, String message) {
        super(message);
        this.code = httpStatus;
    }
}
