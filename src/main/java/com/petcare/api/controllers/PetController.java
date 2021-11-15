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

import com.petcare.api.dtos.PetDto;
import com.petcare.api.entities.Pet;
import com.petcare.api.services.PetService;
import com.petcare.api.utils.ConsistenciaException;
import com.petcare.api.utils.ConversaoUtils;
import com.petcare.api.response.Response;


@RestController
@RequestMapping("/api/pet")
@CrossOrigin(origins = "*")
public class PetController {
	
	private static final Logger Log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private PetService petService;
	
	
	// Retorna os Pets informados no parâmetro
	// @param -> Id do Usuário a ser consultado
	// @return -> Lista de Pets que o Usuário possui
	
	@GetMapping(value = "/usuario/{usuarioId}")
	public ResponseEntity<Response<List<PetDto>>> buscarPorUsuarioId(@PathVariable("usuarioId") int usuarioId) {
		
		Response<List<PetDto>> response = new Response<List<PetDto>>();
		
		try {
			Log.info("Controller: Buscando Pets do Usuário de Id: {}", usuarioId);
			
			Optional<List<Pet>> listaPets = petService.buscarPorUsuarioId(usuarioId);
			
			response.setDados(ConversaoUtils.ConverterLista(listaPets.get()));
			
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
	
	
	// Persiste um Usuário na base
	// @param -> Dados de Entrada do Pet
	// @return -> Dados do Pet persistindo
	
	@PostMapping
	public ResponseEntity<Response<PetDto>> salvar (@Valid @RequestBody PetDto petDto, BindingResult result) {
		
		Response<PetDto> response = new Response<PetDto>();
		
		try {
			Log.info("Controller: Salvando o Pet: {}", petDto.toString());
			
			if(result.hasErrors() ) {
				for (int i = 0; i < result.getErrorCount(); i++) {
					response.adicionarErro(result.getAllErrors().get(i).getDefaultMessage());
				}
				
				Log.info("Controller: Os campos obrigatórios não foram preenchidos");
				
				return ResponseEntity.badRequest().body(response);
			}
			
			Pet pet = this.petService.salvar(ConversaoUtils.Converter(petDto));
			
			response.setDados(ConversaoUtils.Converter(pet));
			
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
	
	
	// Excluí um Pet a partir do Id informado no Parâmetro
	// @Param -> Id do Pet a ser excluído
	// @Return -> Sucesso | Erro
	
	@DeleteMapping(value = "excluir/{idpet}")
	public ResponseEntity<Response<String>> excluirPorId(@PathVariable("idpet") int idpet){
		
		Response<String> response = new Response<String>();
		
		try {
			Log.info("Controller: Excluíndo o Pet de Id: {}", idpet);

			petService.excluirPorId(idpet);
			
			response.setDados("Pet de Id: " + idpet + " excluído com sucesso!");
			
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
