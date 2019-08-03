package com.moviex.controller;

import com.moviex.dto.request.PlayerRequestDto;
import com.moviex.dto.response.PlayerResponseDto;
import com.moviex.parser.KPhim;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/player")
@Api(value = "/player", description = "API lay link play")
public class PlayerController {

    @Autowired
    private KPhim kPhim;

    @PostMapping("/play")
    @ApiOperation(
            value = "Lay link phim tu trang khac"
    )
    public PlayerResponseDto play(@RequestBody PlayerRequestDto requestDto) {
        PlayerResponseDto playerResponseDto = new PlayerResponseDto();
        try {
            playerResponseDto.setData(kPhim.start(requestDto.getLink()));
        } catch (Exception ex) {
            playerResponseDto.setError(ex.getMessage());
            playerResponseDto.setStatus(-1);
        }

        return playerResponseDto;
    }
}
