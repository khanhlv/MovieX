package com.moviex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviex.model.Category;
import com.moviex.service.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findCategoryByStatus(){
        List<Category> list = new ArrayList<>();
        categoryRepository.findCategoryByStatus().forEach(list::add);
        return list;
    }
}
