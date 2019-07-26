package com.moviex.service.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.moviex.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query(value = "SELECT * FROM CATEGORY WHERE STATUS = 1 ORDER BY CATEGORY_ORDER ASC ", nativeQuery = true)
    Collection<Category> findCategoryByStatus();
}