package com.curso.springboot.spring_boot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/params")
public class PramsController {
	
	@GetMapping({"/",""})
	public String index(){
		return "params/index";
	}
	@GetMapping("/string")
	//el parametro es texto y siempre es requerido pero eso se puede cambiar y podemos poner un valor por defecto 
	public String param(@RequestParam(required=false, defaultValue = "un valor por defecto") String texto,  Model model) {
		model.addAttribute("resultado", "El texto enviado o parametro enviado es: "+texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	//Integer,Float, Double  se les conoce como wrapper o clases contenedoras 
	public String getMethodName(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: "+ saludo + " y el numero es "+ numero);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-servlet")
	public String params(HttpServletRequest request, Model model) {
		String saludo= request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}

		model.addAttribute("resultado", "El saludo enviado es: "+ saludo + " y el numero es "+ numero);
		return "params/ver";
	}
	
}
