package com.moviex.service.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.moviex.model.Server;

public interface ServerRepository extends CrudRepository<Server, Long> {
    Collection<Server> findByStatusOOrderByServerIdAsc(Long status);
}