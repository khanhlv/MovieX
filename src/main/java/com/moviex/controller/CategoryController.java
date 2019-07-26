package com.moviex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviex.dto.model.CategoryDto;
import com.moviex.dto.response.CategoryResponseDto;
import com.moviex.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public CategoryResponseDto category() {
        List<CategoryDto> listData = new ArrayList<>();
        CategoryResponseDto responseDto = new CategoryResponseDto();

        categoryService.findCategoryByStatus().forEach(v -> {
            final CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(v.getCategoryId().toString());
            categoryDto.setName(v.getCategoryName());
            listData.add(categoryDto);
        });

        responseDto.setData(listData);

        return responseDto;
    }
}
