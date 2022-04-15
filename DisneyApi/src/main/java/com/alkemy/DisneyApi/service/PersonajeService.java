package com.alkemy.DisneyApi.service;

import java.util.List;

import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.projection.PersonajeProjection;

public interface PersonajeService {

	public List<Personaje> listAll();

	public Personaje save(Personaje personaje);

	public Personaje update(Long id, Personaje personaje);

	public void delete(Long id);

	public boolean exist(Long idDog);

	public List<PersonajeProjection> listAllPersonajeDetails();

	public List<PersonajeProjection> searchByNombre(String nombre);

	public List<PersonajeProjection> searchByEdad(int edad);

	public List<PersonajeProjection> searchByIdPeliSerie(Long id);
}
