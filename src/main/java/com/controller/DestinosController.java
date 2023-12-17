package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Destinos;
import com.repository.DestinosRepository;

@Controller
@RequestMapping("/destinos")
public class DestinosController {
    
	@Autowired
	private DestinosRepository destinosRepository;

	@GetMapping
	public ModelAndView destinos() {
		ModelAndView modelAndView = new ModelAndView("views/destinos/index.html");
		
		modelAndView.addObject("destinos", destinosRepository.findAll());
		modelAndView.addObject("destino", new Destinos());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Destinos destino) {
		destinosRepository.save(destino);

		return "redirect:/destinos";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		destinosRepository.deleteById(id);

		return "redirect:/destinos";
	}

}