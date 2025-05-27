package com.curso.springboot.spring_boot_web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/my-app")  // fuera de nuestro controlador sirve para configurar una ruta base que todos los handlers tendra 
public class HomeControllers {

	//El metodo get en esta notacion esta explícito, podemos en este ejemplo omitir el get o colocar otro metodo
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	//ESte ejemplo es mas corto y tambien el metodo puede ser mapeado a varias rutas 
	//@GetMapping(value = "/index")
	@GetMapping({"/index", "/", "home"})
	
	//Para pasar datos existen 4 formas basicas la cual es con model, ModelMap, Map y ModelAndView(los 4 trabajan con llave:valor )
	//* Model es el que mas se utiliza
	//public String index(Model model) {
	//public String index(ModelMap model) {
	//public String index(Map<String, Object> map) {
	public ModelAndView index(ModelAndView mv) {
		//model.addAttribute("titulo", "Hola Spring Framework! jiji");// model y ModelMap
		//map.put("titulo", "Esto es una prueba con Map");  // Map
		mv.addObject("titulo", "Hola Spring Framework! jijiaaaa");  //ModelAndView
		//return "index"; // model, ModelMap, Map
		mv.setViewName("index");
		return mv;
	}
}
