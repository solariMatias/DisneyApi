package com.alkemy.DisneyApi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.DisneyApi.entity.Personaje;
import com.alkemy.DisneyApi.projection.PersonajeProjection;
import com.alkemy.DisneyApi.repository.PersonajeRepository;
import com.alkemy.DisneyApi.service.PersonajeService;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/characters")
public class PersonajeRestController {

	@Autowired
	private PersonajeService personajeService;

	@GetMapping("/list-all")
	public List<Personaje> listaPersonajes() {
		return this.personajeService.listAll();
	}

	@PostMapping()
	public ResponseEntity<Personaje> guardarPersonaje(@RequestBody Personaje personaje) {
		return new ResponseEntity<Personaje>(this.personajeService.save(personaje), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Personaje> editarPersonaje(@PathVariable("id") Long id, @RequestBody Personaje personaje) {
		return new ResponseEntity<Personaje>(this.personajeService.update(id, personaje), HttpStatus.OK);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<String> eliminarPersonaje(@PathVariable("id") Long id) {
		this.personajeService.delete(id);
		return new ResponseEntity<String>("Personaje con id " + id + " eliminado.", HttpStatus.OK);
	}
	
	@GetMapping(params ="name")
	public ResponseEntity<List<PersonajeProjection>> buscarPorNombre(@RequestParam(value="name",defaultValue = "*") String nombre){
		System.out.println("from name method");
		return nombre.equals("*") ? 
				new ResponseEntity<>(this.personajeService.listAllPersonajeDetails(),HttpStatus.OK) : 
				new ResponseEntity<>(this.personajeService.searchPorNombre(nombre),HttpStatus.OK);
	}
	
	@GetMapping(params ="age")
	public ResponseEntity<List<PersonajeProjection>> buscarPorEdad(@RequestParam(value="age",defaultValue = "0") int edad){
		System.out.println("from age method");
		return edad == 0? 
				new ResponseEntity<>(this.personajeService.listAllPersonajeDetails(),HttpStatus.OK) : 
				new ResponseEntity<>(this.personajeService.searchPorEdad(edad),HttpStatus.OK);
	}
	
	@GetMapping(params ="movies")
	public ResponseEntity<List<PersonajeProjection>> buscarPorIdPeliSerie(@RequestParam(value="idMovie",defaultValue = "0") Long id){
		System.out.println("from peliserie method");
		System.out.println(id);
		id = (long) 7;
		System.out.println(this.personajeService.searchPorIdPeliSerie(id));
		
		return id == 0? 
				new ResponseEntity<>(this.personajeService.listAllPersonajeDetails(),HttpStatus.OK) : 
				new ResponseEntity<>(this.personajeService.searchPorIdPeliSerie(id),HttpStatus.OK);
	}
	
	
}
