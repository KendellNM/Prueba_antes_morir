package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Consulta;

public interface ConsultaService{
	
	Consulta create(Consulta d);
	Consulta update(Consulta d);
	void delete(Long id);
	Optional<Consulta> read(Long id);
	List<Consulta> readAll();

}
