package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Viajantes;
import com.repository.ViajanteRepository;

@Controller
@RequestMapping("/usuarios")
public class ViajanteController {

	@Autowired
	private ViajanteRepository viajanteRepository;

	@GetMapping
	public ModelAndView viajante() {
		ModelAndView modelAndView = new ModelAndView("views/viajantes/index.html");
		
		modelAndView.addObject("viajantes", viajanteRepository.findAll());
		modelAndView.addObject("viajante", new Viajantes());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public String cadastrar(Viajantes viajante) {
		viajanteRepository.save(viajante);

		return "redirect:/viajante";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		viajanteRepository.deleteById(id);

		return "redirect:/viajante";
	}

}