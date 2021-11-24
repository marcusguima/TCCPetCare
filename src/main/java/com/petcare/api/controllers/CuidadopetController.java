package com.petcare.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.api.dtos.CuidadopetDto;
import com.petcare.api.entities.Cuidadopet;
import com.petcare.api.services.CuidadopetService;
import com.petcare.api.utils.ConsistenciaException;
import com.petcare.api.utils.ConversaoUtils;
import com.petcare.api.response.Response;


@RestController
@RequestMapping("/api/cuidadopet")
@CrossOrigin(origins = "*")
public class CuidadopetController {

	
	private static final Logger Log = LoggerFactory.getLogger(PetController.class);
	
	@Autowired
	private CuidadopetService cuidadopetService;
	
	
	// Buscar o CUIDADO pelo ID do PET
	
	@GetMapping(value = "/pet/{petId}")
	public ResponseEntity<Response<List<CuidadopetDto>>> buscarPorPetId(@PathVariable("petId") int petId) {
		
		Response<List<CuidadopetDto>> response = new Response<List<CuidadopetDto>>();
		
		try {
			Log.info("Controller: Buscando os Cuidados do PET de Id: {}", petId);
			
			Optional<List<Cuidadopet>> listaCuidados = cuidadopetService.buscarPorPetId(petId);
			
			response.setDados(ConversaoUtils.ConverterListaCuidado(listaCuidados.get()));
			
			return ResponseEntity.ok(response);
		} catch (ConsistenciaException e) {
			Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
			
			response.adicionarErro(e.getMensagem());
			
			return ResponseEntity.badRequest().body(response);
		}catch (Exception e) {
			Log.error("Controller: Ocorreu um erro na Aplicação: {}", e.getMessage());
			
			response.adicionarErro("Ocorreu um erro na Aplicação: {}", e.getMessage());
			
			return ResponseEntity.status(500).body(response);
		}
		
	}
	
	
	
	
	
	
	
	// SALVAR CUIDADO DO PET
	
	
	@PostMapping
	public ResponseEntity<Response<CuidadopetDto>> salvar (@Valid @RequestBody CuidadopetDto cuidadopetDto, BindingResult result) {
		
		Response<CuidadopetDto> response = new Response<CuidadopetDto>();
		
		try {
			Log.info("Controller: Salvando o CuidadoPET: {}", cuidadopetDto.toString());
			
			if(result.hasErrors() ) {
				for (int i = 0; i < result.getErrorCount(); i++) {
					response.adicionarErro(result.getAllErrors().get(i).getDefaultMessage());
				}
				
				Log.info("Controller: Os campos obrigatórios não foram preenchidos");
				
				return ResponseEntity.badRequest().body(response);
			}
			
			Cuidadopet cuidadopet = this.cuidadopetService.salvar(ConversaoUtils.Converter(cuidadopetDto));
			
			response.setDados(ConversaoUtils.Converter(cuidadopet));
			
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
	
	
	
	// EXCLUIR CUIDADO DO PET
	
	@DeleteMapping(value = "excluir/{idcuidadopet}")
	public ResponseEntity<Response<String>> excluirPorId(@PathVariable("idcuidadopet") int idcuidadopet){
		
		Response<String> response = new Response<String>();
		
		try {
			Log.info("Controller: Excluíndo o CuidadoPET de Id: {}", idcuidadopet);

			cuidadopetService.excluirPorId(idcuidadopet);
			
			response.setDados("CuidadoPET de Id: " + idcuidadopet + " excluído com sucesso!");
			
			return ResponseEntity.ok(response);
		} catch (ConsistenciaException e){
			Log.info("Controller: Inconsistência de dados: {}", e.getMessage());
			
			response.adicionarErro(e.getMensagem());
			
			return ResponseEntity.badRequest().body(response);
		} catch(Exception e){
			Log.error("Controller: Ocorreu um erro na Aplicação: {}", e.getMessage());
			
			response.adicionarErro("Ocorreu um erro na Aplicação: {}", e.getMessage());
			
			return ResponseEntity.status(500).body(response);
		}
		
	}
	
	
	
	
}
