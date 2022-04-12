package com.alkemy.DisneyApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.projection.PersonajeProjection;
import com.alkemy.DisneyApi.repository.PersonajeRepository;

@Service
public class PersonajeServiceImplements implements PersonajeService {

	@Autowired
	PersonajeRepository personajeRepo;

	@Override
	public List<Personaje> listAll() {
		return (List<Personaje>) this.personajeRepo.findAll();
	}

	@Override
	public Personaje save(Personaje personaje) {
		return personajeRepo.save(personaje);
	}

	@Override
	public Personaje update(Long id, Personaje personaje) {
		Personaje personajeToUpdate = this.personajeRepo.findById(id).orElse(null);
		personajeToUpdate.setAllData(personaje);
		return personajeToUpdate;
	}

	@Override
	public void delete(Long id) {
		this.personajeRepo.deleteById(id);
	}

	@Override
	public boolean exist(Long id) {
		return this.personajeRepo.existsById(id);
	}

	@Override
	public List<PersonajeProjection> searchPorNombre(String nombre) {
		return this.personajeRepo.searchPersonajeByNombre(nombre);
	}

	@Override
	public List<PersonajeProjection> listAllPersonajeDetails() {
		return this.personajeRepo.findAllPersonaje();
	}

	@Override
	public List<PersonajeProjection> searchPorEdad(int edad) {
		return this.personajeRepo.searchPersonajeByEdad(edad);
	}

	@Override
	public List<PersonajeProjection> searchPorIdPeliSerie(Long id) {
		return this.personajeRepo.findByPeliculaSerieIdPeliculaSerie(id);
	}

}
