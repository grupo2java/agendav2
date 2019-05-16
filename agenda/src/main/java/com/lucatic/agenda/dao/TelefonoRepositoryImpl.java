package com.lucatic.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lucatic.agenda.model.Telefono;




@Repository
@Transactional(readOnly = true)
public class TelefonoRepositoryImpl implements TelefonoRepositoryCustom{

	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Telefono> getTelefono(String telefono) {
		

		 Query query = entityManager.createNativeQuery("SELECT em.* FROM spring_data_jpa_example.username as em " +
               "WHERE em.username LIKE ?",Telefono.class);
       query.setParameter(1, telefono + "%");
       return query.getResultList();
		
      
	}

}
