package com.moviex.service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.moviex.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {
    @Query(
            value = "SELECT * FROM FILM WHERE STATUS = 1 ORDER BY CREATED_DATE DESC",
            countQuery = "SELECT count(1) FROM FILM WHERE STATUS = 1",
            nativeQuery = true)
    Page<Film> findAllWithPagination(Pageable pageable);

    @Query(
            value = "SELECT * FROM FILM WHERE STATUS = 1 ORDER BY CREATED_DATE DESC, FILM_IMDB DESC",
            countQuery = "SELECT count(1) FROM FILM WHERE STATUS = 1",
            nativeQuery = true)
    Page<Film> findAllIMDBWithPagination(Pageable pageable);

    @Query(
            value = "SELECT F.* FROM FILM F INNER JOIN FILM_CATEGORY FC ON FC.FILM_ID = F.FILM_ID WHERE F.STATUS = 1 AND FC.CATEGORY_ID = :categoryId ORDER BY F.CREATED_DATE DESC",
            countQuery = "SELECT count(1) FROM FILM F INNER JOIN FILM_CATEGORY FC ON FC.FILM_ID = F.FILM_ID WHERE F.STATUS = 1 AND FC.CATEGORY_ID = :categoryId",
            nativeQuery = true)
    Page<Film> findByCategoryWithPagination(Pageable pageable, @Param(value = "categoryId") Long categoryId);

    Film findFilmByFilmId(Long filmId);

    Film findByFilmNameEN(String filmNameEN);

    Film findByFilmSource(String filmSource);
}