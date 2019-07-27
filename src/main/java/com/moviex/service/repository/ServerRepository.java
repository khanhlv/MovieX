package com.moviex.service.repository;

import com.moviex.model.Server;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ServerRepository extends CrudRepository<Server, Long> {
    Collection<Server> findByStatusOrderByServerIdAsc(Long status);
}