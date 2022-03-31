package com.alkemy.DisneyApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.DisneyApi.entity.PeliculaSerie;
	
@Repository
public interface PeliculaSerieRepository extends CrudRepository<PeliculaSerie, Long> {}
