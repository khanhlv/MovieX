package com.moviex.dto.common;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ResponseDto {
    private Date timestamp = new Date();
    private int status = 1;
    private String error = StringUtils.EMPTY;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
