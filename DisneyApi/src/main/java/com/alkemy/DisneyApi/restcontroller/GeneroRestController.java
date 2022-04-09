package com.alkemy.DisneyApi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.entity.Genero;
import com.alkemy.DisneyApi.service.GeneroService;

@RestController
@RequestMapping("/genres")
public class GeneroRestController {

	@Autowired
	private GeneroService generoService;

	@GetMapping()
	public List<Genero> listaGenero() {
		return this.generoService.listAll();
	}

	@PostMapping()
	public Genero guardarGenero(@RequestBody Genero genero) {
		return this.generoService.save(genero);
	}
	
	@GetMapping("/delete/{id}")
	public void eliminarPersonaje(@PathVariable("id") Long id) {
		this.generoService.delete(id);
	}
}
