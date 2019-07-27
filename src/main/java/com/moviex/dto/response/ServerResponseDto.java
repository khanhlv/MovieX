package com.moviex.dto.response;

import com.moviex.dto.common.ResponseDto;
import com.moviex.dto.model.ServerDto;

import java.util.List;

public class ServerResponseDto extends ResponseDto {
    private List<ServerDto> data;

    public List<ServerDto> getData() {
        return data;
    }

    public void setData(List<ServerDto> data) {
        this.data = data;
    }
}
