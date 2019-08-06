package com.moviex.service.repository;

import com.moviex.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
    Actor findActorByActorName(String actorName);
}