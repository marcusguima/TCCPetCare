package com.petcare.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.petcare.api.entities.Pet;
import com.petcare.api.repositories.PetRepository;
import com.petcare.api.repositories.UsuarioRepository;
import com.petcare.api.utils.ConsistenciaException;


@Service
public class PetService {

	private static final Logger Log = LoggerFactory.getLogger(PetService.class);
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Pet> buscarPorId(int idpet) throws ConsistenciaException {
		
		Log.info("Service: Buscando o Pet de Id:", idpet);
		
		Optional<Pet> pet = petRepository.findById(idpet);
		
		if(!pet.isPresent()) {
			Log.info("Service: Nenhum Pet com Id: {} foi encontrado", idpet);
			throw new ConsistenciaException("Nenhum Pet com Id: {} foi encontrado", idpet);
		}
		
		return pet;
		
	}
	
	
	public Optional<List<Pet>> buscarPorUsuarioId(int usuarioId) throws ConsistenciaException {
		
		Log.info("Service: Buscando os Pets do Cliente de Id: {}", usuarioId);
		
		Optional<List<Pet>> pets = Optional.ofNullable(petRepository.findByUsuarioId(usuarioId));
		
		if (!pets.isPresent() || pets.get().size() < 1) {
			
			Log.info("Service: Nenhum Pet encontrado para o Usuário de Id: {}", usuarioId);
			
			throw new ConsistenciaException("Nenhum Pet encontrado para o Usuário de Id: {}", usuarioId);
		}
		
		return pets;
		
	}
	
	
	public Pet salvar(Pet pet) throws ConsistenciaException {
		
		Log.info("Service: Salvando o Pet: {}", pet);
		
		if (!usuarioRepository.findById(pet.getUsuario().getId()).isPresent()) {
			
			Log.info("Service: Nenhum Usuário com Id: {} foi encontrado", pet.getUsuario().getId());
			
			throw new ConsistenciaException("Nenhum Usuário com Id: {} foi encontrado", pet.getUsuario().getId());
			
		}
		
		if(pet.getId() > 0)
			buscarPorId(pet.getId());
		
		try {
			
			return petRepository.save(pet);
			
		} catch(DataIntegrityViolationException e) {
			
			Log.info("Service: Já existe um Pet de Nome {} cadastrado", pet.getNome());
			
			throw new ConsistenciaException("Já existe um Pet de Nome {} cadastrado", pet.getNome());
		}
		
				
	}
	
	
	public void excluirPorId(int idpet) throws ConsistenciaException {
		
		Log.info("Service: Excluindo o Pet de Id: {}", idpet);
		
		buscarPorId(idpet);
		
		petRepository.deleteById(idpet);
		
	}
	
	
}
