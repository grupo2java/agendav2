package com.lucatic.agenda.services;

import java.util.List;

import com.lucatic.agenda.model.Direccion;
import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.model.Provincia;
import com.lucatic.agenda.model.Telefono;

public interface PersonaService {


	public List<Persona> list();
	public void update(Persona perso);
	public void add(Persona perso);
	public void delete(int id);
	public Persona getEmployeeById(int id);
	public List<Telefono> listaTelefonos(int id);
	public List<Direccion> listaDirecciones(int id);
	public List<Provincia> listaProvincias();
	public Provincia tedoyProvincia(int id);
	
}
