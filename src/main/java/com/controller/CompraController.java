package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Compras;
import com.repository.ComprasRepository;
import com.repository.DestinosRepository;
import com.repository.ViajanteRepository;

@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private ComprasRepository comprasRepository; 
	@Autowired
	private ViajanteRepository viajanteRepository; 
	@Autowired 
	private DestinosRepository destinosRepository;

	@GetMapping
	public ModelAndView compras() {
		ModelAndView modelAndView = new ModelAndView("views/compras/index.html");

		modelAndView.addObject("listaViajante", viajanteRepository.findAll());
		modelAndView.addObject("listaDestinos", destinosRepository.findAll());
		modelAndView.addObject("compras", comprasRepository.findAll());
		modelAndView.addObject("compra", new Compras());

		return modelAndView;
	}

	// Aviso: Removido parâmetro desnecessário
	// O parâmetro "ModelMap model" foi removido do método "cadastrar" porque não está sendo usado para adicionar atributos à camada de visualização (pagina html).
	// Se futuramente for necessário adicionar dados à camada de visualização, o parâmetro e as linhas correspondentes podem ser reintroduzidos.
	// Foi removido também a validação com as anotações @Validated e o parâmetro "BindingResult result", para o codigo ficar mais limpo sem muitas camadas.
	// Obs.: O erro estava no formulario.
	@PostMapping("/cadastrar")
	public String cadastrar(@ModelAttribute("compras") Compras compras) {

		// Logica provisoria para salvar o preço do pacote em compras.
		double preco = destinosRepository.findById(compras.getDestino().getId()).get().getPreco();
		compras.setTotal_compra(preco);

        comprasRepository.save(compras);

		return "redirect:/compras";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		comprasRepository.deleteById(id);

		return "redirect:/compras";
	}
}