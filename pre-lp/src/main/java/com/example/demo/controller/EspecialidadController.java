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

import com.example.demo.entity.Especialidad;
import com.example.demo.serviceImpl.EspecialidadServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/especialidad")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadServiceImpl especialidadServiceImpl;
	
	@GetMapping()
	public ResponseEntity<List<Especialidad>> readAll() {
		try {
			
			List<Especialidad> especialidads = especialidadServiceImpl.readAll();
			
			if(especialidads.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);			
			}
				return new ResponseEntity<>(especialidads, HttpStatus.OK);			
		
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Especialidad> setEspecialidad(@Valid @RequestBody Especialidad cat) {
		//TODO: process POST request
		try {
			Especialidad d  = especialidadServiceImpl.create(cat);
			return new ResponseEntity<>(d, HttpStatus.OK);			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEspecialidad(@PathVariable("id") Long id, @Valid @RequestBody Especialidad cat) {
		//TODO: process PUT request
		Optional<Especialidad> d = especialidadServiceImpl.read(id);
		if (d.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(especialidadServiceImpl.update(cat), HttpStatus.OK);			

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> getEspecialidad(@PathVariable("id") Long id) {
		
		try {
			Especialidad d = especialidadServiceImpl.read(id).get();
			return new ResponseEntity<>(d, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Especialidad> delEspecialidad(@PathVariable("id") Long id) {
		
		try {
			especialidadServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
