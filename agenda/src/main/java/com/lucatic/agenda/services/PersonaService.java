package com.lucatic.agenda.services;

import java.util.List;

/**
 * 
 * @author grupo2
 * 
 * @version 2.0
 * 
 * 18/05/2019
 * 
 * Interfaz para la implementacion de los servicios Persona
 * 
 * 
 * 
 * 
 *
 */

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
	public int teVoyadarIdContacto(String nombre, String dni);
	public void addtelefono(String telefono,int idperso );
	public void addDireccion(String direccion,String codpostal,String localidad,int idprovincia,int idpersona);
	public String tedoyNombreLocalidad(int idprovincia);
	
	
}
