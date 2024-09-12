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

import com.example.demo.entity.Paciente;
import com.example.demo.serviceImpl.PacienteServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteServiceImpl pacienteServiceImpl;
	
	@GetMapping()
	public ResponseEntity<List<Paciente>> readAll() {
		try {
			
			List<Paciente> pacientes = pacienteServiceImpl.readAll();
			
			if(pacientes.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);			
			}
				return new ResponseEntity<>(pacientes, HttpStatus.OK);			
		
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Paciente> setPaciente(@Valid @RequestBody Paciente cat) {
		//TODO: process POST request
		try {
			Paciente d  = pacienteServiceImpl.create(cat);
			return new ResponseEntity<>(d, HttpStatus.OK);			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePaciente(@PathVariable("id") Long id, @Valid @RequestBody Paciente cat) {
		//TODO: process PUT request
		Optional<Paciente> d = pacienteServiceImpl.read(id);
		if (d.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(pacienteServiceImpl.update(cat), HttpStatus.OK);			

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> getPaciente(@PathVariable("id") Long id) {
		
		try {
			Paciente d = pacienteServiceImpl.read(id).get();
			return new ResponseEntity<>(d, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> delPaciente(@PathVariable("id") Long id) {
		
		try {
			pacienteServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
