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
import com.petcare.api.dtos.VeterinarioDto;
import com.petcare.api.entities.Pet;
import com.petcare.api.entities.Veterinario;
import com.petcare.api.services.PetService;
import com.petcare.api.services.VeterinarioService;
import com.petcare.api.utils.ConsistenciaException;
import com.petcare.api.utils.ConversaoUtils;
import com.petcare.api.response.Response;

@RestController
@RequestMapping("/api/veterinario")
@CrossOrigin(origins = "*")
public class VeterinarioController {

	private static final Logger Log = LoggerFactory.getLogger(PetController.class);
	
	@Autowired
	private VeterinarioService veterinarioService;
	
	
	// Retorna os Veterinarios informados no parâmetro
	 // Retona os Veterinarios de um determinado PET
		// @param -> Id do Pet a ser consultado
		// @return -> Lista de Veterinarios que o Pet possui
	

	
	@GetMapping(value = "/pet/{petId}")
	public ResponseEntity<Response<List<VeterinarioDto>>> buscarPorPetId(@PathVariable("petId") int petId){
		
		Response<List<VeterinarioDto>> response = new Response<List<VeterinarioDto>>();
		
		try { 
			Log.info("Controller: Buscando os Veterinários do Pet de Id: {}", petId);
			
			Optional<List<Veterinario>> listaVeterinarios = veterinarioService.buscarPorPetId(petId);
			
			response.setDados(ConversaoUtils.ConverterListaVet(listaVeterinarios.get()));
			
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
	
	
	
	
	
	
	
	
	
	// Persiste um Veterinário na base
		// @param -> Dados de Entrada do Veterinario
		// @return -> Dados do Veterinario persistindo
	

	
	@PostMapping
	public ResponseEntity<Response<VeterinarioDto>> salvar(@Valid @RequestBody VeterinarioDto veterinarioDto, BindingResult result){
		
		Response<VeterinarioDto> response = new Response<VeterinarioDto>();	
		
		try {
			Log.info("Controller: Salvando o Veterinário: {}", veterinarioDto.toString());
			
			if(result.hasErrors() ) {
				for (int i = 0; i < result.getErrorCount(); i++) {
					response.adicionarErro(result.getAllErrors().get(i).getDefaultMessage());
				}
				
				Log.info("Controller: Os campos obrigatórios não foram preenchidos");
				
				return ResponseEntity.badRequest().body(response);
			}
		
			Veterinario veterinario = this.veterinarioService.salvar(ConversaoUtils.Converter(veterinarioDto));
			
			response.setDados(ConversaoUtils.Converter(veterinario));
			
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
	
	
	
	
	
	
	
	// Excluí um Veterinário a partir do Id informado no Parâmetro
	 // Excluí um determinado veterinário
		// @Param -> Id do Veterinario a ser excluído
		// @Return -> Sucesso | Erro
	

	@DeleteMapping(value = "excluir/{idveterinario}")
	public ResponseEntity<Response<String>> excluirPorId(@PathVariable("idveterinario") int idveterinario){
		
		Response<String> response = new Response<String>();
		
		try {
			Log.info("Controller: Excluíndo o Veterinário de Id: {}", idveterinario);
			
			veterinarioService.excluirPorId(idveterinario);
			
			response.setDados("Veterinário de Id: " + idveterinario + " excluído com sucesso!");
			
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
