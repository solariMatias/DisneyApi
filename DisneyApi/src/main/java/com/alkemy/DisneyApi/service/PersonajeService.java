package com.alkemy.DisneyApi.service;

import com.alkemy.DisneyApi.entity.Personaje;

public interface PersonajeService {

	public Personaje save(Personaje personaje);
	public Personaje searchPersonajeByParams(String titulo); //es AND y no OR
	public void delete(Long id);
	public boolean exist(Long idDog);
}
