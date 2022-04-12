package com.alkemy.DisneyApi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "PeliculaSerie")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPeliculaSerie")

public class PeliculaSerie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private Long idPeliculaSerie;
	private String imagen;
	private String titulo;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaCreacion;
	private short calificacion;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "personajeEnPeliSeries", // encontrar un mejor nombre para tabla relacional xD
			joinColumns = @JoinColumn(name = "idPeliculaSerie"), inverseJoinColumns = @JoinColumn(name = "idPersonaje"))
	private List<Personaje> personajesEnPeliculaSerie;

	@ManyToOne()
	@JoinColumn(name = "idGenero")
	private Genero genero;

	public Long getIdPeliculaSerie() {
		return idPeliculaSerie;
	}

	public void setIdPeliculaSerie(Long idPeliculaSerie) {
		this.idPeliculaSerie = idPeliculaSerie;
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
