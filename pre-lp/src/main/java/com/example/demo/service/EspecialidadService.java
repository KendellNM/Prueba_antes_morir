package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Especialidad;

public interface EspecialidadService{
	
	Especialidad create(Especialidad d);
	Especialidad update(Especialidad d);
	void delete(Long id);
	Optional<Especialidad> read(Long id);
	List<Especialidad> readAll();

}
