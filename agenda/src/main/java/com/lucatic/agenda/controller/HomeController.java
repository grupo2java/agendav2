package com.lucatic.agenda.controller;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/" )
	public String inicio(ModelMap model) {
		logger.info("--Cargando index--");
		return "index";
	}
	@GetMapping("/listarContactos")
	public String listaContactos(ModelMap model) {
		logger.info("entramos lista de contactos");
		model.addAttribute("personas", persoService.list());
		return "listaContactos";
		/*
		 * model.addAttribute("PersonaList", persoService.list());
		return "UserList"
		 */
	}
	

	//ESTO PREGUNTAR SI ES COORRECTO O MEJOR UTILIZAR POSTMAPPING 11MVPARAM PREGUNTAR GRUPO
	@GetMapping("/volver")
	public String volverInicio() {
		logger.info("volvemos al inicio");
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
			@RequestParam(value ="nacimiento") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime fecha
			) {
	
		persoService.add(new Persona(nombre,apellido1,apellido2,dni,fecha));
		return new ModelAndView("redirect:/");
		}
		
	
	
	@GetMapping("/delete")
	public ModelAndView deleteUser(@RequestParam("id") int id) {
		logger.info("-- en DELETE");
		persoService.delete(id);
		return new ModelAndView("redirect:/");		
	}
		/*
		 * @RequestMapping(method = RequestMethod.GET)
    ResponseEntity main(@RequestParam(name = 'dateTime') @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateTime) {
        // ...
 
        return ResponseEntity.noContent().build()
    }
		 */
	/*
	 *  @RequestMapping(value ="/compruebaLogin",  method = RequestMethod.POST)
    public String compruebaLogin(@RequestParam(value="user",required=false) String use
    		 , @RequestParam(value="password",required=false) String pass
    		 ,Model model
    		) {
    		model.addAttribute("usuario",use);
    		model.addAttribute("contrasenia",pass);
    		
        return "holaMundo";
    }
	 */
	
	
	
	
	
	
	
	
	
}
