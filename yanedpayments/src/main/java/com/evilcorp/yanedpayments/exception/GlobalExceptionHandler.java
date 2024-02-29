package com.evilcorp.yanedpayments.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Map<String, Object>> NotFoundException(NotFoundException e) {
        log.error("Not Found Exception", e);
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Map<String, Object>> BadRequestException(BadRequestException e) {
        log.error("Bad Request Exception", e);
        Map<String, Object> body = new HashMap<>();
        body.put("error", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
