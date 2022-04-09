package com.alkemy.DisneyApi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.entity.PeliculaSerie;
import com.alkemy.DisneyApi.service.PeliculaSerieService;

@RestController
@RequestMapping("/movies")
public class PeliculaRestController {

	@Autowired
	private PeliculaSerieService peliculaSerieService;
	
	@GetMapping()
	public List<PeliculaSerie> listaPeliculaSerie(){
//		List<PeliculaSerie> listita = this.peliculaSerieService.listAll();
//		System.out.println(listita);
		return this.peliculaSerieService.listAll();
	}
	
	@PostMapping()
	public PeliculaSerie guardarPeliculaSerie(@RequestBody PeliculaSerie peliculaSerie) {
		return this.peliculaSerieService.save(peliculaSerie);
	}
}
