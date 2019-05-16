package com.lucatic.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucatic.agenda.dao.TelefonoRepository;
import com.lucatic.agenda.model.Telefono;

public class TelefonoServiceImpl implements TelefonoService{

	@Autowired
	private TelefonoRepository telDAO;
	
	
	@Override
	public List<Telefono> list() {
		
		return telDAO.findAll();
	}

	@Override
	public void update(Telefono tel) {
		// TODO Auto-generated method stub
		telDAO.save(tel);
	}

	@Override
	public void add(Telefono tel) {
		// TODO Auto-generated method stub
		telDAO.save(tel);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		telDAO.deleteById(id);
	}

}
