package com.petcare.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.petcare.api.dtos.UsuarioDto;
import com.petcare.api.entities.Usuario;

public class ConversaoUtils {

	public static Usuario Converter(UsuarioDto usuarioDto) {
		
		Usuario usuario = new Usuario();
		
		if (usuarioDto.getId() != null && usuarioDto.getId() != "")
			usuario.setId(Integer.parseInt(usuarioDto.getId()));
		
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(usuarioDto.getSenha());
		
		return usuario;
		
	}
	
	public static UsuarioDto Converter (Usuario usuario) {
	
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setId(String.valueOf(usuario.getId()));
		usuarioDto.setNome(usuario.getNome());
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setSenha(usuario.getSenha());
		
		return usuarioDto;
			
	}
	
	
}
