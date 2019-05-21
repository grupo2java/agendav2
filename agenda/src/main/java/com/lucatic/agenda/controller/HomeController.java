package com.lucatic.agenda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lucatic.agenda.model.Persona;
import com.lucatic.agenda.services.PersonaService;

/*
 * @author grupo2
 * 
 * @date 20/05/2019
 * 
 * @version 2.0
 * 
 * @Description controlador que hace las tareas de contacto
 * 
 * 
 */

@Controller
public class HomeController {

	@Autowired
	private PersonaService persoService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public String inicio(ModelMap model) {
		logger.info("ENTRAMOS EN EL INDEX DEL PROGRAMA");
		return "index";
	}

	@GetMapping("/listarContactos")
	public String listaContactos(ModelMap model) {
		logger.info("entramos lista de contactos");
		model.addAttribute("personas", persoService.list());

		return "listaContactos";
	}

	@GetMapping("/volver")
	public String volverInicio() {
		logger.info("volvemos al inicio");
		return "redirect:/";
	}

	@GetMapping("/new")
	public String newUser(ModelMap model) {
		logger.info("creamos nueva persona");
		model.addAttribute("persona", new Persona());
		model.addAttribute("countries", persoService.listaProvincias());

		return "formContacto";
	}

	@PostMapping("/save")
	public ModelAndView saveUser(@ModelAttribute Persona pers, RedirectAttributes attributes,
			@RequestParam(value = "telefono", required = false) String tel,
			@RequestParam(value = "direccion", required = false) String dir,
			@RequestParam(value = "codpostal", required = false) String codP,
			@RequestParam(value = "provinciaEscogida", required = false) int provin

	) {
		logger.info("-- en SAVE");
		persoService.add(pers);

		int valorID = persoService.teVoyadarIdContacto(pers.getNombre(), pers.getDni());

		String nombreProvincia = persoService.tedoyNombreLocalidad(provin);
		logger.info("Valor para id : " + valorID);
		logger.debug(nombreProvincia);
		persoService.addtelefono(tel, valorID);
		persoService.addDireccion(dir, codP, nombreProvincia, provin, valorID);
		attributes.addFlashAttribute("msg_anadido", "El contacto ha sido añadido");
		return new ModelAndView("redirect:/");
	}

	@GetMapping("/datos/{id}")
	public String verDetallePersona(@PathVariable("id") int id, ModelMap model) {
		logger.info("ENTRAMOS EN LA VISTA DETALLADA");
		model.addAttribute("personaDetalles", persoService.getEmployeeById(id));
		model.addAttribute("telefonos", persoService.listaTelefonos(id));
		model.addAttribute("direcciones", persoService.listaDirecciones(id));
		model.addAttribute("provincias", persoService.tedoyProvincia(id));
		return "detallesPersona";
	}

	@GetMapping("/borrar/{id}")
	public String borrarContacto(@PathVariable("id") Integer id, RedirectAttributes attributes) {
		logger.info("--en borrar");
		persoService.delete(id);
		attributes.addFlashAttribute("msg_borrado", "El contacto ha sido borrado");
		logger.info("contacto borrado");
		return "redirect:/";
	}

	@RequestMapping("/actualizar/{id}")
	public String actualizarEmp(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("updateContacto", persoService.getEmployeeById(id));
		return "updateContacto";
	}

	@RequestMapping("/buscar")
	public String buscarContactos(@RequestParam(value = "busqueda", required = false) String bus, ModelMap model) {
		logger.info("-- en buscar");
		model.addAttribute("pers", persoService.listaPorBusqueda(bus));
		return "mostrarContacto";
	}

}
