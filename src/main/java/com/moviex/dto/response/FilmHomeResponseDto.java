package com.moviex.dto.response;

import java.util.List;

import com.moviex.dto.common.ResponseDto;
import com.moviex.dto.model.FilmHomeDto;

public class FilmHomeResponseDto extends ResponseDto {
    private List<FilmHomeDto> data;

    public List<FilmHomeDto> getData() {
        return data;
    }

    public void setData(List<FilmHomeDto> data) {
        this.data = data;
    }
}
