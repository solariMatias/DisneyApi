package com.alkemy.DisneyApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.Pelicula;
import com.alkemy.DisneyApi.exception.ResourceNotFoundException;
import com.alkemy.DisneyApi.projection.PeliculaProjection;
import com.alkemy.DisneyApi.repository.PeliculaRepository;

@Service
public class PeliculaServiceImplements implements PeliculaService {

	@Autowired
	PeliculaRepository peliRepo;

	@Override
	public List<Pelicula> listAll() {
		return (List<Pelicula>) this.peliRepo.findAll();
	}

	@Override
	public Pelicula save(Pelicula peliculaSerie) {
		return this.peliRepo.save(peliculaSerie);
	}

	@Override
	public Pelicula update(Long id, Pelicula peli) {
		Optional<Pelicula> peliToUpdate = this.peliRepo.findById(id);
		if (peliToUpdate.isPresent()) {
			peliToUpdate.get().setAllData(peli);
			return this.save(peliToUpdate.get());
		} else {
			throw new ResourceNotFoundException("Pelicula", "Id", id);
		}

	}

	@Override
	public void delete(Long id) {
		if (exist(id)) {
			this.peliRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Pelicula", "Id", id);
		}

	}

	@Override
	public boolean exist(Long id) {
		return this.peliRepo.existsById(id);
	}

	@Override
	public List<PeliculaProjection> searchPeliculaByTitulo(String titulo) {
		List<PeliculaProjection> list = this.peliRepo.findPeliculaByTitulo(titulo);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotFoundException("Pelicula", "titulo", titulo);
		}
	}

	@Override
	public List<PeliculaProjection> searchPeliculaByIdGenero(Long id) {
		List<PeliculaProjection> list = this.peliRepo.findByGenero_IdGenero(id);
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourceNotFoundException("Pelicula", "id_genero", id);
		}
	}

	@Override
	public List<PeliculaProjection> listAllPeliculaProjection() {
		return this.peliRepo.findAllPeliculaSerie();
	}

	@Override
	public List<PeliculaProjection> orderByFechaASC() {
		return this.peliRepo.findAllByOrderByFechaCreacionAsc();
	}

	@Override
	public List<PeliculaProjection> orderByFechaDESC() {
		return this.peliRepo.findAllByOrderByFechaCreacionDesc();
	}

}