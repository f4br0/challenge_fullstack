package com.reto.infrastructure.configuration;

import com.reto.application.dto.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorMessage>> handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return Mono.just(new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler({ResponseStatusException.class})
    public Mono<ResponseEntity<ErrorMessage>> handleResponseStatusException(ResponseStatusException ex) {
        return Mono.just(new ResponseEntity<>(new ErrorMessage(ex.getMessage()), (ex.getStatusCode())));
    }

    @ExceptionHandler(BusinessException.class)
    public Mono<ResponseEntity<ErrorMessage>> handleBusinessException(BusinessException ex) {
        return Mono.just(ResponseEntity.status(ex.getCode()).body(new ErrorMessage(ex.getMessage())));
    }

    private record ErrorMessage(String message) {
    }
}