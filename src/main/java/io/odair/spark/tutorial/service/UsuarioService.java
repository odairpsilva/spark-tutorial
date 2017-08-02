package io.odair.spark.tutorial.service;

import java.util.List;

import io.odair.spark.tutorial.entity.Usuario;
import io.odair.spark.tutorial.repository.UsuarioRepository;
import io.odair.spark.tutorial.validator.UsuarioValidator;

public class UsuarioService {

	public UsuarioService() {
		usuarioRepository = new UsuarioRepository();
	}

	private UsuarioRepository usuarioRepository;

	public Usuario buscarPorId(Long idUsuario) {
		return usuarioRepository.buscarPorId(idUsuario);
	}

	public List<Usuario> listarTodos() {
		return usuarioRepository.listarTodos();
	}

	public Usuario salvar(Usuario usuario) {
		if (UsuarioValidator.isValido(usuario)) {
			return usuarioRepository.salvar(usuario);
		} else {
			return null;
		}
	}

	public Usuario atualizar(Usuario usuario, Long idUsuario) {
		if (UsuarioValidator.isValido(usuario)) {
			Usuario existente = usuarioRepository.buscarPorId(idUsuario);
			if(existente != null) {
				usuario.setId(idUsuario);
				return usuarioRepository.atualizar(usuario);
			} else {
				return usuarioRepository.salvar(usuario);
			}						
		} else {
			return null;
		}
	}

}
