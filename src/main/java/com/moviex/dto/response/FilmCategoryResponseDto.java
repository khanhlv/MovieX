package com.moviex.dto.response;

import java.util.List;

import com.moviex.dto.common.ResponseDto;
import com.moviex.dto.model.FilmCategoryDto;

public class FilmCategoryResponseDto extends ResponseDto {
    private List<FilmCategoryDto> data;

    public List<FilmCategoryDto> getData() {
        return data;
    }

    public void setData(List<FilmCategoryDto> data) {
        this.data = data;
    }
}
