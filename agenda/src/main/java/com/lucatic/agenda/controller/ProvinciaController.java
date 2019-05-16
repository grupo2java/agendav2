package com.lucatic.agenda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lucatic.agenda.dao.ProvinciaRepository;
import com.lucatic.agenda.model.Provincia;


@Controller
public class ProvinciaController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ProvinciaRepository provinciaRepository;
	
	@GetMapping("/listarProvincias")
	public String ProvinciaLista(Model model) {
		logger.info("--Lista de provincias");
		model.addAttribute("provincias",provinciaRepository.findAll());
		return "listaProvincias";
	}
	
	@GetMapping("/nuevaProvincia")
	public String provinciaForm(Model model) {
		logger.info("--Entrando en formulario");
		model.addAttribute("provincia",new Provincia());
		return "provinciaForm";
	}
	
	@PostMapping("/nuevaProvincia")
	public String enviarProvin(Provincia provincia, RedirectAttributes attributes) {
		logger.info("Guardando provincia");
		provinciaRepository.save(provincia);
		attributes.addFlashAttribute("msg_anadido", "La provincia ha sido añadida");
		return "redirect:/";
	}
	
}
