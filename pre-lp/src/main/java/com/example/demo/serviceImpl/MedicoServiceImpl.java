package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MedicoDao;
import com.example.demo.entity.Medico;
import com.example.demo.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{

	@Autowired 
	private MedicoDao dao;
	
	@Override
	public Medico create(Medico d) {
		// TODO Auto-generated method stub
		return dao.create(d);
	}

	@Override
	public Medico update(Medico d) {
		// TODO Auto-generated method stub
		return dao.update(d);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Optional<Medico> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Medico> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
