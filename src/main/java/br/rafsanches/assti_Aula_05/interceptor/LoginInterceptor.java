package br.rafsanches.assti_Aula_05.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.rafsanches.assti_Aula_05.model.bean.Usuario;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		HttpSession session = request.getSession();
		
		Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");
		
		if (usuario == null) {
			response.sendRedirect("login");
		}
		else if(usuario.isAdm() && request.getRequestURI().substring(request.getContextPath().length()).equals("/veiculo")) {
			response.sendRedirect("veiculoAdmin");
		}
		else if(!usuario.isAdm() && request.getRequestURI().substring(request.getContextPath().length()).equals("/veiculoAdmin")) {
			response.sendRedirect("veiculo");
		}
	
		return true;
	}
}
