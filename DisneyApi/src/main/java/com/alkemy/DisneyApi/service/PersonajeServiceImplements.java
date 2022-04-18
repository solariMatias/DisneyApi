package com.alkemy.DisneyApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.exception.ResourceNotFoundException;
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
		Optional<Personaje> personajeToUpdate = this.personajeRepo.findById(id);
		if (personajeToUpdate.isPresent()) {
			personajeToUpdate.get().setAllData(personaje);
			return this.save(personajeToUpdate.get());
		} else {
			throw new ResourceNotFoundException("Personaje", "Id", id);
		}

	}

	@Override
	public void delete(Long id) {
		if (exist(id)) {
			this.personajeRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Personaje", "Id", id);
		}

	}

	@Override
	public boolean exist(Long id) {
		return this.personajeRepo.existsById(id);
	}

	@Override
	public List<PersonajeProjection> searchByNombre(String nombre) {
		List<PersonajeProjection> list = this.personajeRepo.findPersonajeByNombre(nombre);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotFoundException("Personaje", "name", nombre);
		}

	}

	@Override
	public List<PersonajeProjection> searchByEdad(int edad) {
		List<PersonajeProjection> list = this.personajeRepo.findPersonajeByEdad(edad);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotFoundException("Personaje", "age", edad);
		}

	}

	@Override
	public List<PersonajeProjection> searchByIdPeliSerie(Long id) {
		List<PersonajeProjection> list = this.personajeRepo.findByPeliculaSerie_IdPeliculaSerie(id);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotFoundException("Personaje", "id_movie", id);
		}
	}

	@Override
	public List<PersonajeProjection> listAllPersonajeDetails() {
		return this.personajeRepo.findAllPersonaje();
	}

	@Override
	public Personaje findByid(Long id) {
		return this.personajeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", id));
	}

}
