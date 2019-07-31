package com.moviex.controller;

import com.moviex.dto.common.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/crawler")
public class CrawlerController {

    @GetMapping("/index")
    public ResponseDto home() {
        return new ResponseDto();
    }
}
