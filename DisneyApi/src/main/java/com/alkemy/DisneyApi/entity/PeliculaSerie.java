package com.alkemy.DisneyApi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

@Entity
@Table(name = "PeliculaSerie")
public class PeliculaSerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	private Long idPeliculaSerie;
	private String imagen;
	private String titulo;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaCreacion;
	private short calificacion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "personajeEnPeliSeries", //encontrar un mejor nombre para tabla relacional xD
		joinColumns = @JoinColumn(name = "idPersonaje"), 
		inverseJoinColumns = @JoinColumn(name = "idPeliculaSerie"))
	private List<Personaje> personajesEnPeliculaSerie;
	
	@ManyToOne
	@JoinColumn(name = "idGenero")
	private Genero genero;
}
