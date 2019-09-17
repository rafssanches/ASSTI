package br.rafsanches.assti_Aula_05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.rafsanches.assti_Aula_05.model.bean.Usuario;
import br.rafsanches.assti_Aula_05.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping (value = {"/login", "/"})
	public ModelAndView login(HttpServletRequest request) {
		request.getSession().setAttribute("usuarioLogado", null);
		ModelAndView mv = new ModelAndView("login");
		mv.addObject(new Usuario());
		return mv;
	}
	
	@PostMapping ("/fazerLogin")
	public String fazerLogin (Usuario usuario, HttpServletRequest request) {
		Usuario usr = usuarioService.logar(usuario);
		if (usr == null) {
			return "login";
		}
		request.getSession().setAttribute("usuarioLogado", usr);
		return "redirect:/veiculoAdmin";

	}
}
