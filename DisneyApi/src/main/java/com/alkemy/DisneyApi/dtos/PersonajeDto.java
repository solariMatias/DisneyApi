package com.alkemy.DisneyApi.dtos;

import java.util.List;

import com.alkemy.DisneyApi.entity.Pelicula;

public class PersonajeDto {

	private Long idPersonaje;
	private String imagen;
	private String nombre;
	private int edad;
	private double peso;
	private String historia;
	private List<Pelicula> peliculaSerie;
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
	public List<Pelicula> getPeliculaSerie() {
		return peliculaSerie;
	}
	public void setPeliculaSerie(List<Pelicula> peliculaSerie) {
		this.peliculaSerie = peliculaSerie;
	}
	
	
}
