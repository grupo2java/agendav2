package com.lucatic.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatic.agenda.dao.ProvinciaRepository;
import com.lucatic.agenda.model.Provincia;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

	@Autowired
	ProvinciaRepository provinciaDao;
	
	@Override
	public List<Provincia> list() {
		return provinciaDao.findAll();
	}

	@Override
	public void update(Provincia provincia) {
		provinciaDao.save(provincia);
		
	}

	@Override
	public void add(Provincia provincia) {
		provinciaDao.save(provincia);
		
	}

	@Override
	public void delete(int id) {
		provinciaDao.deleteById(id);
		
	}

	@Override
	public Provincia get(int id) {
		return provinciaDao.findById(id);
	}

}
