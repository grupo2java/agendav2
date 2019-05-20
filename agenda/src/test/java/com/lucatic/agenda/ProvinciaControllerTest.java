package com.lucatic.agenda;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatic.agenda.controller.ProvinciaController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinciaControllerTest {

	
	@Autowired
	private ProvinciaController provinciaController;
	
	@Test
	public void contextController() {
		assertThat(provinciaController).isNotNull();
	}
}
