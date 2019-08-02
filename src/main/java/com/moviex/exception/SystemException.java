package com.moviex.exception;

import com.moviex.dto.common.ResponseDto;

public class SystemException extends RuntimeException {

    private ResponseDto responseDto;

    public SystemException(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }

    public SystemException(String message, ResponseDto responseDto) {
        super(message);
        this.responseDto = responseDto;
    }

    public SystemException(String message, Throwable cause, ResponseDto responseDto) {
        super(message, cause);
        this.responseDto = responseDto;
    }

    public SystemException(Throwable cause, ResponseDto responseDto) {
        super(cause);
        this.responseDto = responseDto;
    }


    public ResponseDto getResponseDto() {
        return responseDto;
    }

    public void setResponseDto(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }
}
