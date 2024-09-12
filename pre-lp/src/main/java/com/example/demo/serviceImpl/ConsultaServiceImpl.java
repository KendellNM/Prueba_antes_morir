package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConsultaDao;
import com.example.demo.entity.Consulta;
import com.example.demo.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{

	@Autowired 
	private ConsultaDao dao;
	
	@Override
	public Consulta create(Consulta d) {
		// TODO Auto-generated method stub
		return dao.create(d);
	}

	@Override
	public Consulta update(Consulta d) {
		// TODO Auto-generated method stub
		return dao.update(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Consulta> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Consulta> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
