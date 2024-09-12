package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Consulta;

public interface ConsultaDao {
	
	Consulta create(Consulta d);
	Consulta update(Consulta d);
	void delete(Long id);
	Optional<Consulta> read(Long id);
	List<Consulta> readAll();
	
}
