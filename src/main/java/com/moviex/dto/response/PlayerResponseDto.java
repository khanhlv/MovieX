package com.moviex.dto.response;

import com.moviex.dto.common.ResponseDto;
import com.moviex.parser.bean.KPhimSource;

import java.util.List;

public class PlayerResponseDto extends ResponseDto {
    private List<KPhimSource> data;

    public List<KPhimSource> getData() {
        return data;
    }

    public void setData(List<KPhimSource> data) {
        this.data = data;
    }
}
