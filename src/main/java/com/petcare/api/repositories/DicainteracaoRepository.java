package com.petcare.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.petcare.api.entities.Dicainteracao;
import com.petcare.api.entities.Pet;

public interface DicainteracaoRepository extends JpaRepository<Dicainteracao, Integer>{

	
	
	
	
	// find by tipo dica and especie dica - Consulta para identificar as proprias dicas de interacao que possui atualmente na base
	//consultinha padrao
	
	@Transactional(readOnly = true)
	List<Dicainteracao> findByTipoDicaAndEspecieDica(String tipoDica, String especieDica);
	

}
