package com.petcare.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.petcare.api.entities.Cuidadopet;

@Transactional(readOnly = true)
public interface CuidadopetRepository extends JpaRepository<Cuidadopet, Integer>{

	@Query("SELECT c FROM Cuidadopet c WHERE c.pet.idpet = :petId")
	List<Cuidadopet> findByPetId(@Param("petId") int petId);
		
}