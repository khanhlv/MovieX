package com.moviex.dto.response;

import java.util.List;

import com.moviex.dto.common.ResponseDto;
import com.moviex.dto.model.CategoryDto;

public class CategoryResponseDto extends ResponseDto {
    private List<CategoryDto> data;

    public List<CategoryDto> getData() {
        return data;
    }

    public void setData(List<CategoryDto> data) {
        this.data = data;
    }
}
