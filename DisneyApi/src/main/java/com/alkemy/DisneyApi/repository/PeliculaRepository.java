package com.alkemy.DisneyApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alkemy.DisneyApi.entity.Pelicula;
import com.alkemy.DisneyApi.projection.PeliculaProjection;

@Repository
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {

	@Query("SELECT ps.imagen as imagen, ps.titulo as titulo, ps.fechaCreacion as fechaCreacion FROM Pelicula ps")
	public List<PeliculaProjection> findAllPeliculaSerie();

	public List<PeliculaProjection> findPeliculaByTitulo(@Param("titulo") String titulo);

	public List<PeliculaProjection> findByGenero_IdGenero(@Param("idGenero") Long id);

	public List<PeliculaProjection> findAllByOrderByFechaCreacionAsc();

	public List<PeliculaProjection> findAllByOrderByFechaCreacionDesc();
	
	public void deleteByPersonajesEnPeliculaSerie_IdPersonaje(Long id);
}
