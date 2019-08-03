package com.moviex.controller;

import com.moviex.annotation.AllowAnonymous;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviex.dto.common.ResponseDto;

@RestController
public class HomeController {

    @GetMapping("/")
    @AllowAnonymous
    @ApiOperation(value = "Test API Home")
    public ResponseDto home() {
        return new ResponseDto();
    }
}
