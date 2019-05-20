package com.lucatic.agenda.dao;

import java.util.List;

import com.lucatic.agenda.model.Direccion;
import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.model.Provincia;
import com.lucatic.agenda.model.Telefono;


/**
* 
* @author grupo2
* 
* @Version 2.0
* 
* fecha:15/05/2019
* 
* Descripcion:Repositorio para la clase persona.
* 
* 
*
*/

public interface PersonaRepositoryCustom {

	
	List<Persona> getFirstNombre(String nombre);
	Persona damePersona(int id);
	List<Telefono> dameTelefonos(int id);
	List<Direccion> dameDirecciones(int id);
	List<Provincia> getProvincias();
	Provincia dameTuprovincia(int id);
	public int teDoyIdPersona(String nombre, String dni);
	public void creoTelefono(String telefono,int idperso);
}
