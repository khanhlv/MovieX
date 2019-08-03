package com.moviex.service.repository;

import com.moviex.model.FilmCategory;
import org.springframework.data.repository.CrudRepository;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Long> {

}