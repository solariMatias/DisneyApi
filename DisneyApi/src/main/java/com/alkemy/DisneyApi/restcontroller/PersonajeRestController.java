package com.alkemy.DisneyApi.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.dtos.PersonajeDtos;

import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.projection.PersonajeProjection;
import com.alkemy.DisneyApi.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeRestController {

	@Autowired
	private PersonajeService persSrvc;

	@Autowired
	private ModelMapper modelMapper;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list-all")
	public List<PersonajeDtos> listaPersonajes() {
		List<Personaje> list = this.persSrvc.listAll();
		return list.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public PersonajeDtos guardarPersonaje(@RequestBody Personaje personaje) {
		return convertToDto(this.persSrvc.save(personaje));
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/edit/{id}")
	public PersonajeDtos editarPersonaje(@PathVariable("id") Long id, @RequestBody Personaje personaje) {
		return convertToDto(this.persSrvc.update(id, personaje));
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/delete/{id}")
	public String eliminarPersonaje(@PathVariable("id") Long id) {
		this.persSrvc.delete(id);
		return "Personaje con id " + id + " eliminado.";
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(params = "name")
	public List<PersonajeProjection> buscarPorNombre(@RequestParam(value = "name", defaultValue = "*") String nombre) {
		return nombre.equals("*") ? persSrvc.listAllPersonajeDetails() : persSrvc.searchByNombre(nombre);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(params = "age")
	public List<PersonajeProjection> buscarPorEdad(@RequestParam(value = "age", defaultValue = "0") int edad) {
		return edad == 0 ? persSrvc.listAllPersonajeDetails() : persSrvc.searchByEdad(edad);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(params = "movies")
	public List<PersonajeProjection> buscarPorIdPeliSerie(@RequestParam(value = "movies", defaultValue = "0") Long id) {
		return id == 0 ? persSrvc.listAllPersonajeDetails() : persSrvc.searchByIdPeliSerie(id);
	}

	/*-------------------------------------------------------------------------*/
	private PersonajeDtos convertToDto(Personaje pers) {
		PersonajeDtos persDto = modelMapper.map(pers, PersonajeDtos.class);
		return persDto;
	}
	
//	private Personaje convertToEntity(PersonajeDtos persDto) throws ParseException {
//		Personaje pers = modelMapper.map(persDto, Personaje.class);
//	 
//	    if (persDto.getIdPersonaje() != null) {
//	    	Personaje oldPers = persSrvc.id(persDto.getId());
//	        pers.setRedditID(oldPost.getRedditID());
//	        pers.setSent(oldPost.isSent());
//	    }
//	    return pers;
//	}

}
