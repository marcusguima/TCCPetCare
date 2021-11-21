package com.petcare.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.petcare.api.entities.Pet;
import com.petcare.api.entities.Veterinario;
import com.petcare.api.repositories.VeterinarioRepository;
import com.petcare.api.repositories.PetRepository;
import com.petcare.api.utils.ConsistenciaException;

@Service
public class VeterinarioService {

	private static final Logger Log = LoggerFactory.getLogger(VeterinarioService.class);
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@Autowired
	private PetRepository petRepository;
	

	
	public Optional<Veterinario> buscarPorId(int idveterinario) throws ConsistenciaException {
		
		Log.info("Service: Buscando o Veterinário de Id: {}", idveterinario);
		
		Optional<Veterinario> veterinario = veterinarioRepository.findById(idveterinario);
		
		if(!veterinario.isPresent()) {
			Log.info("Service: Nenhum Veterinário com Id: {} foi encontrado", idveterinario);
			throw new ConsistenciaException("Nenhum Veterinário com Id: {} foi encontrado", idveterinario);
		}
		
		return veterinario;
		
	}
	

	
	
	public Optional<List<Veterinario>> buscarPorPetId(int petId) throws ConsistenciaException {
		
		Log.info("Service: Buscando os Veterinários do Pet de Id: {}", petId);
		
		Optional<List<Veterinario>> veterinarios = Optional.ofNullable(veterinarioRepository.findByPetId(petId));
		
		if(!veterinarios.isPresent() || veterinarios.get().size() < 1) {
			Log.info("Service: Nenhum Veterinário encontrado para o Pet de Id: {}", petId);
			throw new ConsistenciaException("Nenhum Veterinário encontrado para o Pet de Id: {}", petId);
		}
		
		return veterinarios;
		
	}
	
	
	
	// MÉTODO DE SALVAR COM ERRO;
	
	public Veterinario salvar(Veterinario veterinario) throws ConsistenciaException {
		
		Log.info("Service: Salvando o Veterinário: {}", veterinario);
		
		if (!petRepository.findById(veterinario.getPet().getId()).isPresent()){
			
			Log.info("Service: Nenhum Pet com Id: {} foi encontrado", veterinario.getPet().getId());
			throw new ConsistenciaException("Nenhum Pet com Id: {} foi encontrado", veterinario.getPet().getId());
		}
		
		if(veterinario.getId() > 0)
			buscarPorId(veterinario.getId());
		
		try {
			return veterinarioRepository.save(veterinario);
		
		} catch(DataIntegrityViolationException e) {
			Log.info("Service: Já existe um Veterinario de Nome {} cadastrado", veterinario.getNome());
			
			throw new ConsistenciaException("Já existe um Veterinário de Nome {} cadastrado", veterinario.getNome());
		}
		
	}
	
	// Verificar se as relações estão corretas.
	
	// Foi necessário alterar os relacionamentos entre as Tabelas Pet e Veterinario, de 1 para N. Para que a função de salvar possa operar de maneira correta.
	
	
	
	
	
	
	
	

	
	public void excluirPorId (int idveterinario) throws ConsistenciaException {
		Log.info("Service: Excluindo o Veterinário de Id: {}", idveterinario);
		
		buscarPorId(idveterinario);
		
		veterinarioRepository.deleteById(idveterinario);
	}
	
	
}
