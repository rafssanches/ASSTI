package br.rafsanches.assti_Aula_05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rafsanches.assti_Aula_05.model.bean.Usuario;
import br.rafsanches.assti_Aula_05.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepo;
	public Usuario logar (Usuario usuario) {
		return usuarioRepo.findOneByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		
	}

}
