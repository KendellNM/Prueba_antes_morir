package com.example.demo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.PacienteDao;
import com.example.demo.entity.Paciente;
import com.example.demo.repository.PacienteRepository;

@Component
public class PacienteDaoImpls implements PacienteDao{
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public Paciente create(Paciente d) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(d);
	}

	@Override
	public Paciente update(Paciente d) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacienteRepository.deleteById(id);
		
	}

	@Override
	public Optional<Paciente> read(Long id) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

}
