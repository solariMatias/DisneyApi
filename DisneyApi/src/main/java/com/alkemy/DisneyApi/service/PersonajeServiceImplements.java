package com.alkemy.DisneyApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.Personaje;
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
		return this.personajeRepo.save(personaje);
	}

	@Override
	public void delete(Long id) {
		this.personajeRepo.deleteById(id);
	}

	@Override
	public boolean exist(Long id) {
		return this.personajeRepo.existsById(id);
	}

}
