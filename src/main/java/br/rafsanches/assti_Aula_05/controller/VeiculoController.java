package br.rafsanches.assti_Aula_05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.rafsanches.assti_Aula_05.model.bean.Veiculo;
import br.rafsanches.assti_Aula_05.model.repository.VeiculoRepository;
import br.rafsanches.assti_Aula_05.service.VeiculoService;

@Controller
public class VeiculoController {
	
	//injete um serviço
	@Autowired
	private VeiculoService veiculoService;
		
	@GetMapping("/veiculo")
	public ModelAndView listarVeiculos () {
		// passa o nome da página ao construtor
		ModelAndView mv = new ModelAndView ("visualiza_veiculos");
		
		// busque a coleção com o service
		List <Veiculo> veiculos = veiculoService.listarTodos();
		
		// adicione a coleção ao objeto ModelAndView
		mv.addObject("veiculos", veiculos);
				
		//para modelar o formulário
		mv.addObject(new Veiculo());
		
		// devolva o ModelAndView
		return mv;
	}
	
	@GetMapping("/veiculoAdmin")
	public ModelAndView listarVeiculos2 () {
		// passa o nome da página ao construtor
		ModelAndView mv = new ModelAndView ("lista_veiculos");
		
		// busque a coleção com o service
		List <Veiculo> veiculos = veiculoService.listarTodos();
		
		// adicione a coleção ao objeto ModelAndView
		mv.addObject("veiculos", veiculos);
				
		//para modelar o formulário
		mv.addObject(new Veiculo());
		
		// devolva o ModelAndView
		return mv;
	}
	
	@PostMapping ("/veiculoAdmin")
	public String salvar (Veiculo veiculo) {
		//salvando com o service
		veiculoService.salvar(veiculo);
		return "redirect:/veiculo";
	}
}
