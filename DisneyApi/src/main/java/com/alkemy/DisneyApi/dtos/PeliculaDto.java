package com.alkemy.DisneyApi.dtos;

import java.time.LocalDate;
import java.util.List;

import com.alkemy.DisneyApi.entity.Genero;
import com.alkemy.DisneyApi.entity.Personaje;

public class PeliculaDto {

	private Long id;
	private String imagen;
	private String titulo;
	private LocalDate fechaCreacion;
	private short calificacion;
	private List<Personaje> personajesEnPeliculaSerie;
	private Genero genero;

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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
