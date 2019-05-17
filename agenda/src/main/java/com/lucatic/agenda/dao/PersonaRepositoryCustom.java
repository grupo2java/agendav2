package com.lucatic.agenda.dao;

import java.util.List;

import com.lucatic.agenda.model.Direccion;
import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.model.Provincia;
import com.lucatic.agenda.model.Telefono;


public interface PersonaRepositoryCustom {

	//List<User> getFirstNamesLike(String username);
	
	List<Persona> getFirstNombre(String nombre);
	Persona damePersona(int id);
	List<Telefono> dameTelefonos(int id);
	List<Direccion> dameDirecciones(int id);
	List<Provincia> getProvincias();
	Provincia dameTuprovincia(int id);
	
}
