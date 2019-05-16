package com.lucatic.agenda.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.services.PersonaService;

@Controller
public class HomeController {

	@Autowired
	private PersonaService persoService;

	@RequestMapping(value = "/" )
	public String inicio(ModelMap model) {
		System.out.println("ENTRAMOS EN EL INDEX DEL PROGRAMA");
		return "index"; 
	}
	@GetMapping("/listarContactos")
	public String listaContactos(ModelMap model) {
		System.out.println("entramos lista de contactos");
		model.addAttribute("personas", persoService.list());

		return "listaContactos";
	}
	

	//ESTO PREGUNTAR SI ES COORRECTO O MEJOR UTILIZAR POSTMAPPING 11MVPARAM PREGUNTAR GRUPO
	@GetMapping("/volver")
	public String volverInicio() {
		System.out.println("volvemos al inicio");
		return "redirect:/";	
	}
	
	@GetMapping("/new")
	public String newUser(ModelMap model) {
		
		model.addAttribute("persona", new Persona());
		return "formContacto";		
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	
	public ModelAndView saveUser(@RequestParam(value="nombre",required=false) String nombre ,
			@RequestParam(value="apellido1",required=false) String apellido1,
			@RequestParam(value="apellido2",required=false) String apellido2,
			@RequestParam(value="dni",required=false) String dni,
			@RequestParam(value ="nacimiento") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime fecha) {
	
		persoService.add(new Persona());
		return new ModelAndView("redirect:/");
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
}
