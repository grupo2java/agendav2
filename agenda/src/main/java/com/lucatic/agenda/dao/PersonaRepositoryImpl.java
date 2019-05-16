package com.lucatic.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lucatic.agenda.model.Persona;

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

}
