package com.lucatic.agenda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/index")
	public String index(Model model) {
		logger.info("--Lista de provincias");
		
		return "index";
	}
	
	@GetMapping("/nuevaProvincia")
	public String provinciaForm(Model model) {
		logger.info("--Entrando en formulario");
		model.addAttribute("provincia",new Provincia());
		return "provinciaForm";
	}
	
	@PostMapping("/nuevaProvinciaADD")
	public String enviarProvin(@RequestParam(value="user",required=false) String nombrePronvincia
   		 ,Model model, RedirectAttributes attributes) {
		logger.info("Guardando provincia");
		provinciaRepository.save(new Provincia(nombrePronvincia));
		
		attributes.addFlashAttribute("msg_anadido", "La provincia ha sido añadida");
		return "redirect:/";
	}
	
	@GetMapping("/borrarProvincia/{id}")
	public String deleteProvincia(@PathVariable("id") Integer id, RedirectAttributes attributes) {
		
		provinciaRepository.deleteById(id);
		attributes.addFlashAttribute("msg_borrado","La provincia ha sido borrado");
		return "redirect:/";
	}
	
	@RequestMapping("/updateProvincia/{id}")
	public String actualizarProvincia(@PathVariable("id") Integer id, Model model ) {
		model.addAttribute("provincia", provinciaRepository.findById(id));
		return "actualizarProvincia";
	}
	
	@PostMapping("/guardaProvincia")
	public String guardaActualizarProvincia(@RequestParam(value="provinciaid",required=false) int id, 
			@RequestParam(value="provinciaNombre",required=false) String provinciaN ,
			RedirectAttributes attributes) {
		
		
		//attributes.addFlashAttribute("msg_actualizado", "La provincia ha sido actualizado");
		return "redirect:/";
	}
	
	/*
	 * @PostMapping("/actualizar")
	public String guardarActuali(@Valid Particular particular, BindingResult bindingResult, RedirectAttributes attributes) {
		if (bindingResult.hasErrors()) {
			System.out.println("Error en validacion: " + bindingResult.getAllErrors());
			return "actualizarParticular";
		}
		particularRepository.save(particular);
		attributes.addFlashAttribute("msg_actualizado", "El particular ha sido actualizado");
		return "redirect:/";
	}
	 */
	
}
