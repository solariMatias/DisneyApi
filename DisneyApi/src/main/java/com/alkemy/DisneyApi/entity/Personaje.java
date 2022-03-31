package com.alkemy.DisneyApi.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
}
