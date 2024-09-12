package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Medico;

public interface MedicoService{
	
	Medico create(Medico d);
	Medico update(Medico d);
	void delete(Long id);
	Optional<Medico> read(Long id);
	List<Medico> readAll();

}