package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Consulta;
import com.example.demo.repository.ConsultaRepository;
import com.example.demo.serviceImpl.ConsultaServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/controller")
public class ConsultaController {
	
	@Autowired
	private ConsultaServiceImpl consultaRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Consulta>> readAll() {
		try {
			List<Consulta> consultas = consultaRepository.readAll(); 
			if (consultas.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(consultas, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Consulta> postConsulta(@Valid @RequestBody Consulta cat) {
		//TODO: process POST request
		try {
			Consulta consulta = consultaRepository.create(cat);
			return new ResponseEntity<>(consulta, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> getConsulta(@PathVariable("id") Long id) {
		
		try {
			Consulta c = consultaRepository.read(id).get();
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> delConsulta(@PathVariable("id") Long id) {
		
		try {
			consultaRepository.delete(id);
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateConsulta(@PathVariable("id") Long id, @RequestBody Consulta cat) {
		//TODO: process PUT request
		Optional<Consulta> consultas = consultaRepository.read(id);
		
		if(consultas.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

		}else {
			return new ResponseEntity<>(consultaRepository.update(cat), HttpStatus.OK);

		}
		
		
	}
	
	
	
}
