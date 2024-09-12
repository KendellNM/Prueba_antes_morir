package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EspecialidadDao;
import com.example.demo.entity.Especialidad;
import com.example.demo.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

	@Autowired 
	private EspecialidadDao dao;
	
	@Override
	public Especialidad create(Especialidad d) {
		// TODO Auto-generated method stub
		return dao.create(d);
	}

	@Override
	public Especialidad update(Especialidad d) {
		// TODO Auto-generated method stub
		return dao.update(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Especialidad> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Especialidad> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
