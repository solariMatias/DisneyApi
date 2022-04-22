package com.alkemy.DisneyApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.DisneyApi.entity.Pelicula;
import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.exception.DuplicatedItemException;
import com.alkemy.DisneyApi.exception.IncorrectDataInputException;
import com.alkemy.DisneyApi.exception.ResourceNotFoundException;
import com.alkemy.DisneyApi.projection.PeliculaProjection;
import com.alkemy.DisneyApi.repository.PeliculaRepository;
import com.alkemy.DisneyApi.repository.PersonajeRepository;

@Service
public class PeliculaServiceImplements implements PeliculaService {

	@Autowired
	private PeliculaRepository peliRepo;

	@Autowired
	private PersonajeRepository persRepo;

	@Override
	public List<Pelicula> listAll() {
		return (List<Pelicula>) this.peliRepo.findAll();
	}

	@Override
	public Pelicula save(Pelicula peliculaSerie) {
		verifyPeliculaData(peliculaSerie);
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
		List<PeliculaProjection> list = this.peliRepo.findByTitulo(titulo);
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

	@Override
	public Pelicula findById(Long id) {
		return this.peliRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pelicula", "id", id));
	}

	@Override
	public void deletePersonajeFromMovie(Long idPersonaje, Long idPelicula) {

		Pelicula movie = peliRepo.findById(idPelicula)
				.orElseThrow(() -> new ResourceNotFoundException("Pelicula", "id", idPelicula));
		Personaje pers = persRepo.findById(idPersonaje)
				.orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", idPersonaje));
		
		if(movie.getPersonajesEnPeliculaSerie().contains(pers)) {
			movie.removePersonaje(pers);
			this.peliRepo.save(movie);
		}else {
			throw new ResourceNotFoundException("Personaje", "id_personaje", idPersonaje);
		}
		
	}

	@Override
	public void addPersonajeOnMovie(Long idPersonaje, Long idPelicula) {
		Pelicula movie = peliRepo.findById(idPelicula)
				.orElseThrow(() -> new ResourceNotFoundException("Pelicula", "id", idPelicula));
		Personaje pers = persRepo.findById(idPersonaje)
				.orElseThrow(() -> new ResourceNotFoundException("Personaje", "id", idPersonaje));
		
		if(movie.getPersonajesEnPeliculaSerie().contains(pers)) {
			throw new DuplicatedItemException();
		}else {
			movie.addPersonaje(pers);
			this.peliRepo.save(movie);
		}
		
		
	}

	private void verifyPeliculaData(Pelicula pelicula) {
		if (pelicula.getIdPeliculaSerie() != null)
			throw new IncorrectDataInputException("Pelicula", "id_personaje");
		
	}
}
