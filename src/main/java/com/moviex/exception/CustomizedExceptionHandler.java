package com.moviex.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviex.dto.common.CustomErrorResponse;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    public final ResponseEntity<?> handleAuthorizationException(Exception ex, WebRequest request) {

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        customErrorResponse.setError("khong truy cap duoc");
        customErrorResponse.setTimestamp(new Date());

        return new ResponseEntity<>(customErrorResponse, HttpStatus.UNAUTHORIZED);
    }
}