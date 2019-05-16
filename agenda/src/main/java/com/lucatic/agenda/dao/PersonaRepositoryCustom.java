package com.lucatic.agenda.dao;

import java.util.List;

import com.lucatic.agenda.model.Persona;

public interface PersonaRepositoryCustom {

	//List<User> getFirstNamesLike(String username);
	
	List<Persona> getFirstNombre(String nombre);
}
