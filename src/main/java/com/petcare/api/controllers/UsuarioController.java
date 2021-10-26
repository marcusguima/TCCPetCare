package com.petcare.api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.api.entities.Usuario;
import com.petcare.api.services.UsuarioService;
import com.petcare.api.utils.ConsistenciaException;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	private static final Logger Log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	// Retorna os dados de um Usuário a partir do seu Id;
	// @param -> Id do Usuário;
	// @return -> Dados do Usuário;
	
	@GetMapping(value = "/{idusuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable("idusuario") int idusuario){
		
		try {
			Log.info("Controller: Buscando usuário com id: {}", idusuario);
			
			Optional<Usuario> usuario = usuarioService.buscarPorId(idusuario);
			
			return ResponseEntity.ok(usuario.get());
			
		} catch (ConsistenciaException e) {
			Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
			
			return ResponseEntity.badRequest().body(new Usuario());
			
		} catch (Exception e) {
			Log.error("Controller: Ocorreu um erro na aplicação: {}", e.getMessage());
			
			return ResponseEntity.status(500).body(new Usuario());
		}
		
	}
	
	
	
	// Retorna os dados de um Usuário a partir do Email informado;
	// @param -> Email do Usuário;
	// @return -> Dados do Usuário;
	
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<Usuario> buscarPorEmail(@PathVariable("email") String email) {
		
		try {
			Log.info("Controller: Buscando cliente por Email: {}", email);
			
			Optional<Usuario> usuario = usuarioService.buscarPorEmail(email);
			
			return ResponseEntity.ok(usuario.get());
			
		} catch (ConsistenciaException e) {
			Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
			
			return ResponseEntity.badRequest().body(new Usuario());
		} catch(Exception e) {
			Log.error("Controller: Ocorreu um erro na aplicação: {}", e.getMessage());
			
			return ResponseEntity.status(500).body(new Usuario());
		}
		
	}
	
	
	//Persiste um Usuário na base;
	// @param Dados de entrada do Usuário;
	// @return Dados do Usuário persistindo;
	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		
		try {
			Log.info("Controller: Salvando o Usuário: {}", usuario.toString());
			
			return ResponseEntity.ok(this.usuarioService.salvar(usuario));
		} catch (ConsistenciaException e) {
			Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
			
			return ResponseEntity.status(500).body(new Usuario());
		}
		
		
	}
	

}
