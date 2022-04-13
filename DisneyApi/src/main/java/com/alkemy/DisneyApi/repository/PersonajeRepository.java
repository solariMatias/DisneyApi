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

	public List<PersonajeProjection> findPersonajeByNombre(@Param("nombre") String nombre);

	public List<PersonajeProjection> findPersonajeByEdad(@Param("edad") int edad);

	public List<PersonajeProjection> findByPeliculaSerie_IdPeliculaSerie(@Param("idPeliculaSerie") Long id);


}
