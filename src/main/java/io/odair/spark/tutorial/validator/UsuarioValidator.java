package io.odair.spark.tutorial.validator;

import io.odair.spark.tutorial.entity.Usuario;
import spark.utils.StringUtils;

public class UsuarioValidator {

	public static boolean isValido(Usuario usuario) {
		return (usuario != null && !StringUtils.isEmpty(usuario.getEmail()) && !StringUtils.isEmpty(usuario.getNome()));
	}

}
