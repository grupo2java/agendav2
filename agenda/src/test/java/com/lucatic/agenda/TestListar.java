package com.lucatic.agenda;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatic.agenda.services.PersonaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestListar {

	@Autowired
	private PersonaService persoService;
	@Test
	public void contextLoads() {
		
		assertThat(persoService.list()).isNotNull();
		
	}

}
