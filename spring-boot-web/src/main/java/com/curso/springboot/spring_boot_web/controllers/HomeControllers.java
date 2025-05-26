package com.curso.springboot.spring_boot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControllers {

	//El metodo get en esta notacion esta explícito, podemos en este ejemplo omitir el get o colocar otro metodo
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	//ESte ejemplo es mas corto y tambien el metodo puede ser mapeado a varias rutas 
	//@GetMapping(value = "/index")
	@GetMapping({"/index", "/", "home"})
	public String index() {
		return "index";
	}
}
