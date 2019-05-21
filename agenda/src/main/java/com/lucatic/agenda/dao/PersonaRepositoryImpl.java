package com.lucatic.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
* Descripcion:Metodos implementados del repositorio persona.
* 
* 
*
*/


@Repository
@Transactional(readOnly = true)
public class PersonaRepositoryImpl implements PersonaRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Provincia dameTuprovincia(int id) {
		// TODO Auto-generated method stub

		Query query = entityManager.createNativeQuery(
				"SELECT em.idprovincia FROM agenda_mini.direccion as em " + "WHERE em.idpersona LIKE ?");
		query.setParameter(1, id);

		int valor = (int) query.getSingleResult();

		return entityManager.find(Provincia.class, valor);

	}

	@Override
	public List<Persona> busquedaPorPalabra(String palabraBusqueda) {
		
		
		Query query = entityManager.createNativeQuery("SELECT p.* FROM agenda_mini.persona as p " +
                "WHERE p.nombre LIKE ?", Persona.class);
        query.setParameter(1, palabraBusqueda + "%");
        return query.getResultList();
		
		
	}

	@Override
	public Persona damePersona(int id) {
		// TODO Auto-generated method stub
		
		
		return entityManager.find(Persona.class,id);
	}

	@Override
	public List<Telefono> dameTelefonos(int id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM agenda_mini.telefono as em " +
                "WHERE em.idpersona LIKE ?", Telefono.class);
		  query.setParameter(1, id + "%");
		return query.getResultList();
	}

	@Override
	public List<Direccion> dameDirecciones(int id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM agenda_mini.direccion as em " +
                "WHERE em.idpersona LIKE ?", Direccion.class);
		  query.setParameter(1, id + "%");
		return query.getResultList();
	}

	@Override
	public List<Provincia> getProvincias() {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createNativeQuery("SELECT * FROM agenda_mini.provincia ",Provincia.class);
   
		return query.getResultList();
		
	}

	@Override
	public int teDoyIdPersona(String nombre,String dni) {
		
		Query query = entityManager.createNativeQuery("SELECT em.idpersona FROM agenda_mini.persona as em "
				+ "WHERE em.nombre LIKE ? AND em.dni LIKE ? ");
		 query.setParameter(1, nombre);
		 query.setParameter(2,dni);
		
		 
		 int valor = (int) query.getSingleResult();
		return valor;
		
	}

	@Override
	public void creoTelefono(String telefono, int idperso) {
		// TODO Auto-generated method stub

		Query query = entityManager.createNativeQuery("INSERT INTO agenda_mini.telefono (telefono,idpersona) VALUES (?,?) ");
		 query.setParameter(1, telefono);
		 query.setParameter(2,idperso);
		query.executeUpdate();
	
	}

	@Override
	public void creoDireccion(String direccion, String codpostal, String localidad, int idprovincia, int idpersona) {
		
		Query query = entityManager.createNativeQuery("INSERT INTO agenda_mini.direccion (direccion,codpostal,localidad,idprovincia,idpersona) VALUES (?,?,?,?,?) ");
		 query.setParameter(1,direccion);
		 query.setParameter(2,codpostal);
		 query.setParameter(3,localidad);
		 query.setParameter(4,idprovincia);
		 query.setParameter(5,idpersona);
		 
		 
		 
		query.executeUpdate();
		
	}

	@Override
	public String nombreProvincia(int idprovincia) {
		// TODO Auto-generated method stub
		
		Query query = entityManager.createNativeQuery("SELECT em.provincia FROM agenda_mini.provincia as em WHERE em.idprovincia LIKE ?");
		 query.setParameter(1, idprovincia);
		
		 
	String nombre = (String) query.getSingleResult();
		return nombre;
	}
	
	
	
	




	
	 
	
	
	

	
	
	


}
