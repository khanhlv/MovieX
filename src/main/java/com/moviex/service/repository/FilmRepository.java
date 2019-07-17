package com.moviex.service.repository;


import com.moviex.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
//    @Query("SELECT coalesce(max(e.id), 0) FROM Employee e WHERE ID = :id")
//    Long getMaxId(String id);
}