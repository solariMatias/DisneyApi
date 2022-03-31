package com.alkemy.DisneyApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.entity.Genero;
import com.alkemy.DisneyApi.service.GeneroService;

@RestController
@RequestMapping("/genre")
public class GeneroController {

	@Autowired
	GeneroService generoService;

	@GetMapping()
	public List<Genero> listaGenero() {
		return this.generoService.listAll();
	}

	@PostMapping()
	public Genero guardarGenero(@RequestBody Genero genero) {
		return this.generoService.save(genero);
	}

}
