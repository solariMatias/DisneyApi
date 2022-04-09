package com.alkemy.DisneyApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.PeliculaSerie;
import com.alkemy.DisneyApi.repository.PeliculaSerieRepository;

@Service
public class PeliculaSerieServiceImplements implements PeliculaSerieService{

	@Autowired
	PeliculaSerieRepository peliculaSerieRepo;

	@Override
	public List<PeliculaSerie> listAll() {
		return (List<PeliculaSerie>) this.peliculaSerieRepo.findAll();
	}

	@Override
	public PeliculaSerie save(PeliculaSerie peliculaSerie) {
		return this.peliculaSerieRepo.save(peliculaSerie);
	}

	@Override
	public PeliculaSerie searchPeliculaSerieByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PeliculaSerie searchPeliculaSerieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exist(Long idDog) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
