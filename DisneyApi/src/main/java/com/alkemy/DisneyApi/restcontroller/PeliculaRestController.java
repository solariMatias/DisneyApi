package com.alkemy.DisneyApi.restcontroller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.dtos.PeliculaDto;

import com.alkemy.DisneyApi.entity.Pelicula;
import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.projection.PeliculaProjection;
import com.alkemy.DisneyApi.service.GeneroService;
import com.alkemy.DisneyApi.service.PeliculaService;
import com.alkemy.DisneyApi.service.PersonajeService;

import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("/movies")
public class PeliculaRestController {

	@Autowired
	private PeliculaService peliSrvc;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PersonajeService persSrvc;

	@Autowired
	private GeneroService generoSrvc;
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list-all")
	public List<PeliculaDto> listaPeliculaSerie() {
		List<Pelicula> list = peliSrvc.listAll();
		return list.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.CREATED)

	@PostMapping("/create")
	public PeliculaDto guardarPeliculaSerie(@RequestBody PeliculaDto peliDto) throws ParseException {
		Pelicula movie = convertToEntity(peliDto);
		List<Personaje> list = new ArrayList<>();
		for (Personaje p : peliDto.getPersonajesEnPeliculaSerie()) {
			list.add(persSrvc.findByid(p.getIdPersonaje()));
		}
		movie.setPersonajesEnPeliculaSerie(list);
		movie.setGenero(generoSrvc.findById(peliDto.getGenero().getIdGenero()));

		return convertToDto(this.peliSrvc.save(movie));
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/edit/{id}")
	public PeliculaDto editarPelicula(@PathVariable("id") Long id, @RequestBody Pelicula peli) {
		return convertToDto(this.peliSrvc.update(id, peli));
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public String eliminarPelicula(@PathVariable("id") Long id) {
		this.peliSrvc.delete(id);
		return "Pelicula con id  " + id + " eliminado";
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(params = "name")
	public List<PeliculaProjection> buscarPorTitulo(@RequestParam(value = "name", defaultValue = "*") String titulo) {
		return titulo.equals("*") ? peliSrvc.listAllPeliculaProjection() : peliSrvc.searchPeliculaByTitulo(titulo);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(params = "genre")
	public List<PeliculaProjection> buscarPorIdGenero(@RequestParam(value = "genre", defaultValue = "0") Long id) {
		return id == 0 ? peliSrvc.listAllPeliculaProjection() : peliSrvc.searchPeliculaByIdGenero(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(params = "order")
	public List<PeliculaProjection> listaOrdenPor(@RequestParam(value = "order", defaultValue = "*") String orden) {
		orden = orden.toUpperCase();
		if (orden.equals("*")) {
			return this.peliSrvc.listAllPeliculaProjection();
		} else if (orden.equals("ASC")) {
			return this.peliSrvc.orderByFechaASC();
		} else {
			return this.peliSrvc.orderByFechaDESC();
		}
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id_movie}/characters/{id_charc}")
	public String agregarPersonajeEnPelicula(@PathVariable("id_movie") Long idPeli,
			@PathVariable("id_charc") Long idPers) {
		this.peliSrvc.addPersonajeOnMovie(idPers, idPeli);

		return "Personaje con id: " + idPers + " agregado en pelicula: " + idPeli;
	}

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id_movie}/characters/{id_charc}")
	public String eliminarPersonajeEnPelicula(@PathVariable("id_movie") Long idPeli,
			@PathVariable("id_charc") Long idPers) {
		this.peliSrvc.deletePersonajeFromMovie(idPers, idPeli);

		return "Personaje con id: " + idPers + " eliminado de pelicula: " + idPeli;
	}

	/*-------------------------------------------------------------------------*/
	private PeliculaDto convertToDto(Pelicula movie) {
		PeliculaDto movieDto = modelMapper.map(movie, PeliculaDto.class);
		return movieDto;
	}

	private Pelicula convertToEntity(PeliculaDto movieDto) throws ParseException {
		Pelicula movie = modelMapper.map(movieDto, Pelicula.class);
		if (movieDto.getId() != null) {
			Pelicula oldMovie = peliSrvc.findById(movieDto.getId());
			movie.setAllData(oldMovie);
			movie.setPersonajesEnPeliculaSerie(oldMovie.getPersonajesEnPeliculaSerie());
		}
		return movie;
	}

}
