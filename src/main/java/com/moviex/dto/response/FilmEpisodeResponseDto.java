package com.moviex.dto.response;

import com.moviex.dto.common.ResponseDto;
import com.moviex.dto.model.FilmEpisodeDto;

import java.util.List;

public class FilmEpisodeResponseDto extends ResponseDto {
    private List<FilmEpisodeDto> data;

    public List<FilmEpisodeDto> getData() {
        return data;
    }

    public void setData(List<FilmEpisodeDto> data) {
        this.data = data;
    }
}
