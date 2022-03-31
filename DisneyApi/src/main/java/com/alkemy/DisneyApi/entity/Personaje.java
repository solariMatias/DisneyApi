package com.alkemy.DisneyApi.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Personaje")
public class Personaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private Long idPersonaje;
	private String imagen;
	private String nombre;
	private int edad;
	private double peso;
	private String historia;
	
	
	@ManyToMany(mappedBy = "personajesEnPeliculaSerie")
	
	private List<PeliculaSerie> peliculaSerie;


	public Long getIdPersonaje() {
		return idPersonaje;
	}


	public void setIdPersonaje(Long idPersonaje) {
		this.idPersonaje = idPersonaje;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public String getHistoria() {
		return historia;
	}


	public void setHistoria(String historia) {
		this.historia = historia;
	}


	public List<PeliculaSerie> getPeliculaSerie() {
		return peliculaSerie;
	}


	public void setPeliculaSerie(List<PeliculaSerie> peliculaSerie) {
		this.peliculaSerie = peliculaSerie;
	}
	
}
