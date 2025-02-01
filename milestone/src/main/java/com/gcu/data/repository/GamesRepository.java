package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.GameEntity;

public interface GamesRepository extends CrudRepository<GameEntity, Long> {

}
