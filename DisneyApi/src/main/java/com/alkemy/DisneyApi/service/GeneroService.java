package com.alkemy.DisneyApi.service;

import java.util.List;

import com.alkemy.DisneyApi.entity.Genero;

public interface GeneroService {
	
	public List<Genero> listAll();
	public Genero save(Genero genero);
	public void delete(Long id);
	public Genero findById(Long id);
}
