package com.alkemy.DisneyApi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.entity.Genero;
import com.alkemy.DisneyApi.service.GeneroService;

@RestController
@RequestMapping("/genres")
public class GeneroRestController {

	@Autowired
	private GeneroService generoService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/list-all")
	public List<Genero> listaGenero() {
		return this.generoService.listAll();
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public Genero guardarGenero(@RequestBody Genero genero) {
		return this.generoService.save(genero);
	}
	
}
