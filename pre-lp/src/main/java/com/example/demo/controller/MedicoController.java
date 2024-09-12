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

import com.example.demo.entity.Medico;
import com.example.demo.serviceImpl.MedicoServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/medico")
public class MedicoController {
	
	@Autowired
	private MedicoServiceImpl medicoServiceImpl;
	
	@GetMapping()
	public ResponseEntity<List<Medico>> readAll() {
		try {
			
			List<Medico> medicos = medicoServiceImpl.readAll();
			
			if(medicos.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);			
			}
				return new ResponseEntity<>(medicos, HttpStatus.OK);			
		
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Medico> setMedico(@Valid @RequestBody Medico cat) {
		//TODO: process POST request
		try {
			Medico d  = medicoServiceImpl.create(cat);
			return new ResponseEntity<>(d, HttpStatus.OK);			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMedico(@PathVariable("id") Long id, @Valid @RequestBody Medico cat) {
		//TODO: process PUT request
		Optional<Medico> d = medicoServiceImpl.read(id);
		if (d.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(medicoServiceImpl.update(cat), HttpStatus.OK);			

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> getMedico(@PathVariable("id") Long id) {
		
		try {
			Medico d = medicoServiceImpl.read(id).get();
			return new ResponseEntity<>(d, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Medico> delMedico(@PathVariable("id") Long id) {
		
		try {
			medicoServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
