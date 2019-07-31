package com.moviex.exception;

import com.moviex.dto.common.ResponseDto;
import org.springframework.http.HttpStatus;

public class SystemException extends RuntimeException {
    private ResponseDto responseDto;

    public SystemException(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }

    public SystemException(String message, ResponseDto responseDto) {
        super(message);
        this.responseDto = responseDto;
    }

    public ResponseDto getResponseDto() {
        responseDto.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
        return responseDto;
    }

    public void setResponseDto(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
