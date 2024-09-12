package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombres", length = 55)
	private String nombres;
	
	@Column(name = "apellidos", length = 55)
	private String apellidos;

	
	@Column(name = "fecha_consulta")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_consulta;

	
	@Column(name = "direccion", length = 45)
	private String direccion;

	@Column(name = "telefono", length = 9)
	private String telefono;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientes")
	@JsonIgnore
	private Set<Consulta> consultas = new HashSet<>();

}
