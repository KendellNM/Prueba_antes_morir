package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "fecha_consulta")
	@Temporal(TemporalType.DATE)
	private Date fecha_consulta;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consulta_1", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Diagnostico> diagnosticos = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name = "pacientes_id", nullable = false)
	private Paciente pacientes;
	
	@ManyToOne
	@JoinColumn(name = "medico_id", nullable = false)
	private Medico medico_1;
	
}
