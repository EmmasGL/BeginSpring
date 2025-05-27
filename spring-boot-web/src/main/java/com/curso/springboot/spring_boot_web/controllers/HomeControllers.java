package com.curso.springboot.spring_boot_web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.curso.springboot.spring_boot_web.models.Usuario;

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
	
	@RequestMapping("/perfil")
	public String perfil(Model model) { 
		Usuario usuario = new Usuario();
		usuario.setNombre("Emmas");
		usuario.setApellido("Gomez");
		usuario.setEmail("emmas@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Emmas","Gomez","emma@correo.com"));
		usuarios.add(new Usuario("Diego","Valencia","diego@correo.com"));
		usuarios.add(new Usuario("Crispin","Gomez","crispin@correo.com"));
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
}
