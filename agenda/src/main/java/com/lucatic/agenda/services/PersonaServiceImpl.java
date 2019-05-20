package com.lucatic.agenda.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatic.agenda.dao.PersonaRepository;
import com.lucatic.agenda.model.Direccion;
import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.model.Provincia;
import com.lucatic.agenda.model.Telefono;
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

	@Override
	public Persona getEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		return personaDAO.damePersona(id);
	
		
	}

	@Override
	public List<Telefono> listaTelefonos(int id) {
		// TODO Auto-generated method stub
		return personaDAO.dameTelefonos(id);
	}

	@Override
	public List<Direccion> listaDirecciones(int id) {
		// TODO Auto-generated method stub
		return personaDAO.dameDirecciones(id);
	}

	@Override
	public List<Provincia> listaProvincias() {
		// TODO Auto-generated method stub
		return personaDAO.getProvincias();
	}

	@Override
	public Provincia tedoyProvincia(int id) {
		// TODO Auto-generated method stub
		return personaDAO.dameTuprovincia(id);
	}

	@Override
	public int teVoyadarIdContacto(String nombre, String dni) {
		// TODO Auto-generated method stub
		return personaDAO.teDoyIdPersona(nombre, dni);
	}

	@Override
	public void addtelefono(String telefono, int idperso) {
		// TODO Auto-generated method stub
		personaDAO.creoTelefono(telefono, idperso);
	}

	

	
	
	 
	 

	


}
