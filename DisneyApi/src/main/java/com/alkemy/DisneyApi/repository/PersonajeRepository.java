package com.alkemy.DisneyApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.DisneyApi.entity.Personaje;
	
@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {}
