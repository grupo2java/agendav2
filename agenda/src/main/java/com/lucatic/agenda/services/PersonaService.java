package com.lucatic.agenda.services;

import java.util.List;

import com.lucatic.agenda.model.Persona;

public interface PersonaService {


	public List<Persona> list();
	public void update(Persona perso);
	public void add(Persona perso);
	public void delete(int id);
	
}
