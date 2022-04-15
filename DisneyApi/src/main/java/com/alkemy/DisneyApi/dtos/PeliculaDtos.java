package com.alkemy.DisneyApi.dtos;

import java.time.LocalDate;
import java.util.List;

import com.alkemy.DisneyApi.entity.Personaje;

public class PeliculaDtos {

	private Long id;
	private String imagen;
	private String titulo;
	private LocalDate fechaCreacion;
	private short calificacion;
	private List<Personaje> personajesEnPeliculaSerie;

//
//	public PeliculaSerieDtos(PeliculaSerie movie) {
//		this.id = movie.getIdPeliculaSerie();
//		this.imagen = movie.getImagen();
//		this.titulo = movie.getTitulo();
//		this.fechaCreacion = movie.getFechaCreacion();
//		this.calificacion = movie.getCalificacion();
//		this.personajesEnPeliculaSerie = movie.getPersonajesEnPeliculaSerie();
//	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public short getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(short calificacion) {
		this.calificacion = calificacion;
	}

	public List<Personaje> getPersonajesEnPeliculaSerie() {
		return personajesEnPeliculaSerie;
	}

	public void setPersonajesEnPeliculaSerie(List<Personaje> personajesEnPeliculaSerie) {
		this.personajesEnPeliculaSerie = personajesEnPeliculaSerie;
	}

}
