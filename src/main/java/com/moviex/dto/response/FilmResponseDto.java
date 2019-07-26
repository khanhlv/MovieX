package com.moviex.dto.response;

import com.moviex.dto.common.ResponseDto;
import com.moviex.dto.model.FilmDto;

import java.util.List;

public class FilmResponseDto extends ResponseDto {
    private List<FilmDto> data;

    public List<FilmDto> getData() {
        return data;
    }

    public void setData(List<FilmDto> data) {
        this.data = data;
    }
}
