package com.lucatic.agenda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatic.agenda.controller.HomeController;
import com.lucatic.agenda.dao.PersonaRepository;
import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.services.PersonaServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JUnitListarContactos {
	
	@Autowired
	private PersonaRepository personaDAO;
	
	public List<Persona> list() {		
		return personaDAO.findAll();
		
	}
	
	@Test
	public void lista () throws Exception {
		assertThat(personaDAO).isNotNull();
		
	}

}
