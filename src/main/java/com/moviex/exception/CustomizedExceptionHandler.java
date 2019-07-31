package com.moviex.exception;

import com.moviex.dto.common.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public final ResponseDto handleException(SystemException ex, WebRequest request) {

        ResponseDto customErrorResponse = new ResponseDto();
        customErrorResponse.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        customErrorResponse.setError(ex.getResponseDto().getError());
        customErrorResponse.setTimestamp(new Date());

        return ex.getResponseDto();
    }

}
