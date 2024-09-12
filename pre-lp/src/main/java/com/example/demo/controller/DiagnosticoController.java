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

import com.example.demo.entity.Diagnostico;
import com.example.demo.serviceImpl.DiagnosticoServiceImpl;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/diagnostico")
public class DiagnosticoController {
	
	@Autowired
	private DiagnosticoServiceImpl diagnosticoServiceImpl;
	
	@GetMapping()
	public ResponseEntity<List<Diagnostico>> readAll() {
		try {
			
			List<Diagnostico> diagnosticos = diagnosticoServiceImpl.readAll();
			
			if(diagnosticos.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);			
			}
				return new ResponseEntity<>(diagnosticos, HttpStatus.OK);			
		
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Diagnostico> setDiagnostico(@Valid @RequestBody Diagnostico cat) {
		//TODO: process POST request
		try {
			Diagnostico d  = diagnosticoServiceImpl.create(cat);
			return new ResponseEntity<>(d, HttpStatus.OK);			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDiagnostico(@PathVariable("id") Long id, @Valid @RequestBody Diagnostico cat) {
		//TODO: process PUT request
		Optional<Diagnostico> d = diagnosticoServiceImpl.read(id);
		if (d.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(diagnosticoServiceImpl.update(cat), HttpStatus.OK);			

		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostico> getDiagnostico(@PathVariable("id") Long id) {
		
		try {
			Diagnostico d = diagnosticoServiceImpl.read(id).get();
			return new ResponseEntity<>(d, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Diagnostico> delDiagnostico(@PathVariable("id") Long id) {
		
		try {
			diagnosticoServiceImpl.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
