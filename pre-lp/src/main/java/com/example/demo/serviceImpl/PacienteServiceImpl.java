package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PacienteDao;
import com.example.demo.entity.Paciente;
import com.example.demo.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired 
	private PacienteDao dao;
	
	@Override
	public Paciente create(Paciente d) {
		// TODO Auto-generated method stub
		return dao.create(d);
	}

	@Override
	public Paciente update(Paciente d) {
		// TODO Auto-generated method stub
		return dao.update(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Paciente> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
