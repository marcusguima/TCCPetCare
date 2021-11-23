package com.petcare.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petcare.api.entities.Dicainteracao;
import com.petcare.api.entities.Pet;
import com.petcare.api.repositories.DicainteracaoRepository;
import com.petcare.api.utils.ConsistenciaException;

@Service
public class DicainteracaoService {

	
	private static final Logger Log = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private DicainteracaoRepository dicainteracaoRepository;
	
	// buscar por id - PADRAO - Buscar uma dica de interacao atraves de seu id
	
	public Optional<Dicainteracao> buscarPorId(int iddica) throws ConsistenciaException {
		
		Log.info("Service: Buscando uma Dica de Interação com o Id: {}", iddica);
		
		Optional<Dicainteracao> dicainteracao = dicainteracaoRepository.findById(iddica);
		
		if(!dicainteracao.isPresent()) {
			
			Log.info("Service: Nenhuma Dica de Interação com Id: {} foi encontrada.", iddica);
			
			throw new ConsistenciaException("Nenhuma Dica de Interação com Id: {} foi encontrada.", iddica);
			
		}
		
		return dicainteracao;
		
		
	}
	
	
	
	
	
	
	
	
	
	
		// find by tipo dica and especie dica - Consulta para identificar as proprias dicas de interacao que possui atualmente na base
		
		public Optional<List<Dicainteracao>> buscarPorTipoeEspecie(String tipoDica, String especieDica) throws ConsistenciaException {
			
			Log.info("Service: Buscando uma Dica de Interação com o Tipo: {} e Especie: {}", tipoDica, especieDica);
			
			Optional<List<Dicainteracao>> dicasinteracao = Optional.ofNullable(dicainteracaoRepository.findByTipoDicaAndEspecieDica(tipoDica, especieDica));
			
			if(!dicasinteracao.isPresent()) {
				Log.info("Service: Nenhuma Dica de Interação com o tipo: '{}' e especie '{}' foi encontrada", tipoDica, especieDica);
				throw new ConsistenciaException("Nenhuma Dica de Interação com o tipo: '{}' e especie '{}' foi encontrada", tipoDica, especieDica);
				
			}
			
			return dicasinteracao;
			
		}
		
		
		
		
		
		// Retorna todas as Dicas de Interação
		
		public Optional<List<Dicainteracao>> buscarTodasAsDicas() throws ConsistenciaException {
			
			Log.info("Service: Buscando todas as Dicas de Interação");
			
			Optional<List<Dicainteracao>> dicasinteracao = Optional.ofNullable(dicainteracaoRepository.findAll());
			
			if(!dicasinteracao.isPresent() || dicasinteracao.get().size() < 1) {
				Log.info("Service: Nenhuma Dica de Interação foi encontrada.");
				throw new ConsistenciaException("Nenhuma Dica de Interação foi encontrada.");
			}
			return dicasinteracao;
		}
		
		
		
		
}
		
