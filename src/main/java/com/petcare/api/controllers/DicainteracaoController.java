package com.petcare.api.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.api.dtos.DicainteracaoDto;
import com.petcare.api.dtos.PetDto;
import com.petcare.api.entities.Dicainteracao;
import com.petcare.api.entities.Pet;
import com.petcare.api.response.Response;
import com.petcare.api.services.DicainteracaoService;
import com.petcare.api.utils.ConsistenciaException;
import com.petcare.api.utils.ConversaoUtils;





@RestController
@RequestMapping("/api/dicainteracao")
@CrossOrigin(origins = "*")
public class DicainteracaoController {
	
	
	private static final Logger Log = LoggerFactory.getLogger(DicainteracaoController.class);
	
	private DicainteracaoService dicainteracaoService;
	
	
	// buscar por id - PADRAO - Buscar uma dica de interacao atraves de seu id
			
			@GetMapping(value = "/{iddica}")
			public ResponseEntity<Response<DicainteracaoDto>> buscarPorId(@PathVariable("iddica") int iddica){
				
				Response<DicainteracaoDto> response = new Response<DicainteracaoDto>();
				
				try {
					
					Log.info("Controller: Buscando uma Dica de Interação com Id: {}", iddica);
					
					Optional<Dicainteracao> dicainteracao = dicainteracaoService.buscarPorId(iddica);
					
					response.setDados(ConversaoUtils.Converter(dicainteracao.get()));
					
					return ResponseEntity.ok(response);
					
				} catch (ConsistenciaException e) {
					
					Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
					
					response.adicionarErro(e.getMensagem());
					
					return ResponseEntity.badRequest().body(response);
					
				} catch(Exception e){
					
					Log.error("Controller: Ocorreu um erro na Aplicação: {}", e.getMessage());
					
					response.adicionarErro("Ocorreu um erro na Aplicação: {}", e.getMessage());
					
					return ResponseEntity.status(500).body(response);
					
				}
				
				
			}
			
			
			
			
			
			
			
			//Retorna as Dicas de interação Pelo TIPO e pela ESPECIE da Dica
			//
			//
			
			@GetMapping(value = "/dicas/{tipoDica}/{especieDica}")
			public ResponseEntity<Response<List<DicainteracaoDto>>> buscarPorTipoAndEspecie(@PathVariable("tipoDica") String tipoDica, @PathVariable("especieDica") String especieDica ){
				
				Response<List<DicainteracaoDto>> response = new Response<List<DicainteracaoDto>>();
				
				try {
					
					Log.info("Controller: Buscando as Dicas de Interação com Tipo: {} e Especie: {}", tipoDica, especieDica);
					
					Optional<List<Dicainteracao>> dicasinteracao = dicainteracaoService.buscarPorTipoeEspecie(tipoDica, especieDica);
					
					response.setDados(ConversaoUtils.Converter(dicasinteracao.get()));
					
					return ResponseEntity.ok(response);
					
					
				} catch (ConsistenciaException e){
					
					Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
					response.adicionarErro(e.getMensagem());
					return ResponseEntity.badRequest().body(response);
					
				} catch (Exception e) {
					
					Log.error("Controller: Ocorreu um erro na Aplicação: {}", e.getMessage());
					response.adicionarErro("Ocorreu um erro na Aplicação: {}", e.getMessage());
					return ResponseEntity.status(500).body(response);
						
				}
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			// Retorna todas as Dicas de Interacao
			// @return Lista de todas as dicas de interação cadastradas
			
			@GetMapping(value = "/todas")
			public ResponseEntity<Response<List<DicainteracaoDto>>> buscarTodasAsDicas(){
				
				Response<List<DicainteracaoDto>> response = new Response<List<DicainteracaoDto>>();
				
				try {
					
					Log.info("Controller: Buscando todas as Dicas de Interação");
					
					Optional<List<Dicainteracao>> dicasinteracao = dicainteracaoService.buscarTodasAsDicas();
					
					response.setDados(ConversaoUtils.Converter(dicasinteracao.get()));
					
					return ResponseEntity.ok(response);
					
				} catch (ConsistenciaException e) {
					Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
					response.adicionarErro(e.getMensagem());
					return ResponseEntity.badRequest().body(response);
						
				} catch (Exception e) {
					
					Log.error("Controller: Ocorreu um erro na Aplicação: {}", e.getMessage());
					response.adicionarErro("Ocorreu um erro na Aplicação: {}", e.getMessage());
					return ResponseEntity.status(500).body(response);
					
				}
				
				
				
				
			}
			
			
			
			
			
			
}
