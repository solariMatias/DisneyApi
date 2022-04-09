package com.alkemy.DisneyApi.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.DisneyApi.entity.Personaje;

public interface PersonajeService {

	public List<Personaje> listAll();

	public Personaje save(Personaje personaje);

	
	// public Personaje searchPersonajeByParams(String titulo); //es AND y no OR
	public void delete(Long id);

	public boolean exist(Long idDog);
}
