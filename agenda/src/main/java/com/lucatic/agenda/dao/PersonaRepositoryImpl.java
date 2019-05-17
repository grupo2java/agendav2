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






@Repository
@Transactional(readOnly = true)
public class PersonaRepositoryImpl implements PersonaRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Persona> getFirstNombre(String nombre) {
		// TODO Auto-generated method stub
		
		/*
		 * Query query = entityManager.createNativeQuery("SELECT em.* FROM spring_data_jpa_example.username as em " +
                "WHERE em.username LIKE ?", User.class);
        query.setParameter(1, username + "%");
        return query.getResultList();
		 */
		return null;
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
		
		Query query = entityManager.createNativeQuery("SELECT * FROM agenda_mini.provincia ");
   
		return query.getResultList();
		
	}

	@Override
	public Provincia dameTuprovincia(int id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery("SELECT em.idprovincia FROM agenda_mini.direccion as em " +
                "WHERE em.idpersona LIKE ?", Direccion.class);
		 query.setParameter(1, id + "%");
		 	((Number)query.getSingleResult()).intValue();
		 return null;
		
		
	}




	
	 
	
	
	

	
	
	


}
