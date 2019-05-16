package com.lucatic.agenda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lucatic.agenda.model.Provincia;
import com.lucatic.agenda.services.ProvinciaService;

@Controller
public class ProvinciaController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ProvinciaService proviService;
	
	@GetMapping("/listarProvincias")
	public String listaProvincias(ModelMap model) {
		logger.info("-- En provincias");
		model.addAttribute("provincias",proviService.list());
		
		return "listaProvincias";
	}
	
	@GetMapping("/nuevaProvincia")
	public String provinciaForm(ModelMap model) {
		logger.info("--Añadiendo provincia");
		model.addAttribute("provincia", new Provincia());
		return "provinciaForm";
	}
	
	@RequestMapping(value="/saveProvincia", method=RequestMethod.POST)
	public ModelAndView saveProvincia(@RequestParam(value="provincia",required=false)String provincia, RedirectAttributes attributes) {
		proviService.add(new Provincia(provincia));
		attributes.addFlashAttribute("msg_anadido", "La provincia ha sido añadida");
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/actualizar/{id}")
	public String actualizarEmp(@PathVariable("id") Integer id, ModelMap model ) {
		model.addAttribute("provincia", proviService.get(id));
		return "actualizarEmpresa";
	}
	
	
}
