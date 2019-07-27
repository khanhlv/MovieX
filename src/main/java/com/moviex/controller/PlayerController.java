package com.moviex.controller;

import com.moviex.dto.request.PlayerRequestDto;
import com.moviex.dto.response.PlayerResponseDto;
import com.moviex.parser.KPhim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private KPhim kPhim;

    @PostMapping("/play")
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
