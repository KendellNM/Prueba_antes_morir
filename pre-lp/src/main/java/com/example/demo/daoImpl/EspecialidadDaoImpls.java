package com.example.demo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EspecialidadDao;
import com.example.demo.entity.Especialidad;
import com.example.demo.repository.EspecialidadRepository;

@Component
public class EspecialidadDaoImpls implements EspecialidadDao{
	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	@Override
	public Especialidad create(Especialidad d) {
		// TODO Auto-generated method stub
		return especialidadRepository.save(d);
	}

	@Override
	public Especialidad update(Especialidad d) {
		// TODO Auto-generated method stub
		return especialidadRepository.save(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		especialidadRepository.deleteById(id);
		
	}

	@Override
	public Optional<Especialidad> read(Long id) {
		// TODO Auto-generated method stub
		return especialidadRepository.findById(id);
	}

	@Override
	public List<Especialidad> readAll() {
		// TODO Auto-generated method stub
		return especialidadRepository.findAll();
	}

}
