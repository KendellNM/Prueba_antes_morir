package com.example.demo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ConsultaDao;
import com.example.demo.entity.Consulta;
import com.example.demo.repository.ConsultaRepository;

@Component
public class ConsultaDaoImpls implements ConsultaDao{
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	public Consulta create(Consulta d) {
		// TODO Auto-generated method stub
		return consultaRepository.save(d);
	}

	@Override
	public Consulta update(Consulta d) {
		// TODO Auto-generated method stub
		return consultaRepository.save(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		consultaRepository.deleteById(id);
		
	}

	@Override
	public Optional<Consulta> read(Long id) {
		// TODO Auto-generated method stub
		return consultaRepository.findById(id);
	}

	@Override
	public List<Consulta> readAll() {
		// TODO Auto-generated method stub
		return consultaRepository.findAll();
	}

}
