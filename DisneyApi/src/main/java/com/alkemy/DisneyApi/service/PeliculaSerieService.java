package com.alkemy.DisneyApi.service;

import java.util.List;

import com.alkemy.DisneyApi.entity.PeliculaSerie;

public interface PeliculaSerieService {

	public List<PeliculaSerie> listAll();
	public PeliculaSerie save(PeliculaSerie peliculaSerie);
	public PeliculaSerie searchPeliculaSerieByTitulo(String titulo);
	public PeliculaSerie searchPeliculaSerieById(Long id);
	public void delete(Long id);
	public boolean exist(Long idDog);
}
