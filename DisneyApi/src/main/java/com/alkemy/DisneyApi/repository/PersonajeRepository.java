package com.alkemy.DisneyApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.projection.PersonajeProjection;

@Repository
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {

	@Query("SELECT p.imagen as imagen, p.nombre as nombre FROM Personaje p")
	public List<PersonajeProjection> findAllPersonaje();

	public List<PersonajeProjection> searchPersonajeByNombre(@Param("nombre") String nombre);

	public List<PersonajeProjection> searchPersonajeByEdad(@Param("edad") int edad);

//	@Query("SELECT p.imagen as imagen, p.nombre as nombre "
//			+ "FROM Personaje p "
//			+ "JOIN p.personaje_en_peli_series pps"
//			
//			+ "WHERE pps.id_personaje =:idPeliSerie")
	public List<PersonajeProjection> findByPeliculaSerieIdPeliculaSerie(@Param("idPeliculaSerie") Long id);

}
