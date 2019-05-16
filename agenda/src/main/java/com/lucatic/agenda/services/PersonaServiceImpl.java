package com.lucatic.agenda.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatic.agenda.dao.PersonaRepository;
import com.lucatic.agenda.model.Persona;
@Service
@Transactional
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository personaDAO;
	
	
	@Override
	public List<Persona> list() {
		// TODO Auto-generated method stub
		return personaDAO.findAll();
	}

	@Override
	public void update(Persona perso) {
		// TODO Auto-generated method stub
		personaDAO.save(perso);
		
	}

	@Override
	public void add(Persona perso) {
		// TODO Auto-generated method stub
		personaDAO.save(perso);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		personaDAO.deleteById(id);
		
	}

}
