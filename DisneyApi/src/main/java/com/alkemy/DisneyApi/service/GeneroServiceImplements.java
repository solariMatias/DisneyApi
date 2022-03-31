package com.alkemy.DisneyApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.Genero;
import com.alkemy.DisneyApi.repository.GeneroRepository;

@Service
public class GeneroServiceImplements implements GeneroService {

	@Autowired
	GeneroRepository generoRepo;

	@Override
	public List<Genero> listAll() {
		return (List<Genero>) this.generoRepo.findAll();
	}

	@Override
	public Genero save(Genero genero) {
		return this.generoRepo.save(genero);
	}

}
