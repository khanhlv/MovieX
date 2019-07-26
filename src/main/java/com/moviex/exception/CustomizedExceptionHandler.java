package com.moviex.exception;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.moviex.dto.common.ResponseDto;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public final ResponseEntity<?> handleException(SystemException ex, WebRequest request) {

        ResponseDto customErrorResponse = new ResponseDto();
        customErrorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        customErrorResponse.setError("SystemException.");
        customErrorResponse.setTimestamp(new Date());

        return new ResponseEntity<>(customErrorResponse, HttpStatus.UNAUTHORIZED);
    }

}
