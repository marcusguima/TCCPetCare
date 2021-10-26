package com.petcare.api.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service; 
import com.petcare.api.entities.Usuario;
import com.petcare.api.repositories.UsuarioRepository;
import com.petcare.api.utils.ConsistenciaException; 

@Service
public class UsuarioService {
	
	private static final Logger Log = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> buscarPorId(int idusuario) throws ConsistenciaException {
		
		Log.info("Service: Buscando um cliente com o id: {}", idusuario);
		
		Optional<Usuario> usuario = usuarioRepository.findById(idusuario);
		
		if(!usuario.isPresent()) {
			
			Log.info("Service: Nenhum usuário com id: {} foi encontrado", idusuario);
			throw new ConsistenciaException("Nenhum usuário com id: {} foi encontrado", idusuario);
			
			}
		
			return usuario;
		
	}
		
		public Optional<Usuario> buscarPorEmail(String email) throws ConsistenciaException{
			
			Log.info("Service: Buscando um usuário com o Email: {}", email);
			
			Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByEmail(email));
			
			if (!usuario.isPresent()) {
				
				Log.info("Service: Nenhum usuário com Email: {} foi encontrado", email);
				throw new ConsistenciaException("Nenhum usuário com Email: {} foi encontrado", email);

			}
			
			return usuario;
		
		}
		
		
		public Usuario salvar(Usuario usuario) throws ConsistenciaException {
			
			Log.info("Service: Salvando o Usuário: {}", usuario);
			
			if(usuario.getId() > 0)
				buscarPorId(usuario.getId());
			
			try {
				return usuarioRepository.save(usuario);
			} catch(DataIntegrityViolationException e) {
				Log.info("Service: O Email: {} já está cadastrado para outro usuário", usuario.getEmail());
				throw new ConsistenciaException("O Email: {} já está cadastrado para outro usuário", usuario.getEmail());
			}
			
		}
		
		
		
	}
	
	
	

