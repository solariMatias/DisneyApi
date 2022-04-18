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

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "PeliculaSerie")

@JsonIdentityReference(alwaysAsId = false)
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private Long idPeliculaSerie;
	private String imagen;
	private String titulo;
	private LocalDate fechaCreacion;
	private short calificacion;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "personajeEnPeliSeries", joinColumns = @JoinColumn(name = "idPeliculaSerie"), inverseJoinColumns = @JoinColumn(name = "idPersonaje"))
	@JsonIgnore
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

	public void setAllData(Pelicula peli) {
		setImagen(peli.getImagen());
		setTitulo(peli.getTitulo());
		setFechaCreacion(peli.getFechaCreacion());
		setCalificacion(peli.getCalificacion());
	}
	
	public void addPersonaje(Personaje pers) {
        this.personajesEnPeliculaSerie.add(pers);
        pers.getPeliculaSerie().add(this);
    }
  
    public void removePersonaje(Personaje pers) {
        this.personajesEnPeliculaSerie.remove(pers);
        pers.getPeliculaSerie().remove(this);
    }
	

}
