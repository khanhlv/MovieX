package com.moviex.controller;

import com.moviex.dto.model.CategoryDto;
import com.moviex.dto.response.CategoryResponseDto;
import com.moviex.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
@Api(value = "/category", description = "API the loai")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @ApiOperation(
            value = "Danh sach the loai",
            notes = "Danh sach the loai duoc loc theo dieu kien trang thai va sap xep theo giam dan"
    )
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
