package com.alkemy.DisneyApi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.service.PersonajeService;

@RestController
@RequestMapping("/characters")
public class PersonajeRestController {

	@Autowired
	PersonajeService personajeService;

	@GetMapping()
	public List<Personaje> listaPersonajes() {
		return this.personajeService.listAll();
	}
	
	@PostMapping()
	public Personaje guardarPersonaje(@RequestBody Personaje personaje) {
		return this.personajeService.save(personaje);
	}
	
	@GetMapping("/delete/{id}")
	public void eliminarPersonaje(@PathVariable("id") Long id) {
		this.personajeService.delete(id);
	}
}
