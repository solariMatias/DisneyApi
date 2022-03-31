package com.alkemy.DisneyApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.DisneyApi.entity.Genero;
	
@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long> {}
