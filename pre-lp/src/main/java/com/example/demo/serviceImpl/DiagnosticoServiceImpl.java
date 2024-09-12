package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DiagnosticoDao;
import com.example.demo.entity.Diagnostico;
import com.example.demo.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService{

	@Autowired 
	private DiagnosticoDao dao;
	
	@Override
	public Diagnostico create(Diagnostico d) {
		// TODO Auto-generated method stub
		return dao.create(d);
	}

	@Override
	public Diagnostico update(Diagnostico d) {
		// TODO Auto-generated method stub
		return dao.update(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Diagnostico> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Diagnostico> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
