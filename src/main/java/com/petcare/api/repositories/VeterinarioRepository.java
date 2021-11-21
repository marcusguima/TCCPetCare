package com.petcare.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.petcare.api.entities.Veterinario;

@Transactional(readOnly = true)
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {

	@Query("SELECT v FROM Veterinario v WHERE v.pet.idpet =:petId")
	List<Veterinario> findByPetId(@Param("petId") int petId);
	
}
