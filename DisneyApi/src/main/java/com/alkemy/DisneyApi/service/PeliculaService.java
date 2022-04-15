package com.alkemy.DisneyApi.service;

import java.util.List;

import com.alkemy.DisneyApi.entity.Pelicula;
import com.alkemy.DisneyApi.projection.PeliculaProjection;

public interface PeliculaService {

	public List<Pelicula> listAll();

	public Pelicula save(Pelicula peliculaSerie);

	public Pelicula update(Long id, Pelicula peli);

	public void delete(Long id);

	public boolean exist(Long id);

	public List<PeliculaProjection> searchPeliculaByTitulo(String titulo);

	public List<PeliculaProjection> searchPeliculaByIdGenero(Long id);

	public List<PeliculaProjection> orderByFechaASC();

	public List<PeliculaProjection> orderByFechaDESC();

	public List<PeliculaProjection> listAllPeliculaProjection();

}
