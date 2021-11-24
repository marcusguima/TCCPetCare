package com.petcare.api.services;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.petcare.api.entities.Cuidadopet;
import com.petcare.api.entities.Pet;
import com.petcare.api.repositories.CuidadopetRepository;
import com.petcare.api.repositories.PetRepository;
import com.petcare.api.repositories.UsuarioRepository;
import com.petcare.api.utils.ConsistenciaException;


@Service
public class CuidadopetService {

	private static final Logger Log = LoggerFactory.getLogger(CuidadopetService.class);
	
	@Autowired
	private CuidadopetRepository cuidadopetRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	
	
	// Buscar Por Id - Buscar o Cuidado PET atraves de seu Id
	public Optional<Cuidadopet> buscarPorId(int idcuidadopet) throws ConsistenciaException {
		
		Log.info("Service: Buscando o CuidadoPET de Id: {}", idcuidadopet);
		
		Optional<Cuidadopet> cuidadopet = cuidadopetRepository.findById(idcuidadopet);
		
		if(!cuidadopet.isPresent()) {
			Log.info("Service: Nenhum CuidadoPET com Id: {} foi encontrado", idcuidadopet);
			throw new ConsistenciaException("Nenhum CuidadoPET com Id: {} foi encontrado", idcuidadopet);
		}
		
		return cuidadopet;
		
	}
	
	
	
	
	// Buscar pelo Id do Pet - Buscar o cuidado do Pet atraves do Id do Pet
	public Optional<List<Cuidadopet>> buscarPorPetId(int petId) throws ConsistenciaException {
		
		Log.info("Service: Buscando os Cuidados do PET de Id: {}", petId);
		
		Optional<List<Cuidadopet>> cuidadospet = Optional.ofNullable(cuidadopetRepository.findByPetId(petId));
		
		if (!cuidadospet.isPresent() || cuidadospet.get().size() < 1) {
			
			Log.info("Service: Nenhum Cuidado foi encontrado para o PET de Id: {}", petId);
			
			throw new ConsistenciaException("Nenhum Cuidado foi encontrado para o PET de Id: {}", petId);
		}
		
		return cuidadospet;
		
	}
	
	
	
	// Salvar Cadastro
	public Cuidadopet salvar(Cuidadopet cuidadopet) throws ConsistenciaException {
	
		Log.info("Service: Salvando o Cuidado do PET: {}", cuidadopet);
	
		if (!petRepository.findById(cuidadopet.getPet().getId()).isPresent()) {
		
			Log.info("Service: Nenhum PET com Id: {} foi encontrado", cuidadopet.getPet().getId());
		
			throw new ConsistenciaException("Nenhum PET com Id: {} foi encontrado", cuidadopet.getPet().getId());
		
			}
	
		if(cuidadopet.getId() > 0)
			buscarPorId(cuidadopet.getId());
		
			return cuidadopetRepository.save(cuidadopet);
			
		}
	
	
	// Excluir CuidadoPet
	public void excluirPorId(int idcuidadopet) throws ConsistenciaException {
	
		Log.info("Service: Excluindo o CuidadoPET de Id: {}", idcuidadopet);
	
		buscarPorId(idcuidadopet);
	
		cuidadopetRepository.deleteById(idcuidadopet);
	
	}
	
}
