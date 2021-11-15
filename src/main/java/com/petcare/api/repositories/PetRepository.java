package com.petcare.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.petcare.api.entities.Pet;

@Transactional(readOnly = true)
public interface PetRepository extends JpaRepository<Pet, Integer> {
	
	@Query("SELECT p FROM Pet p WHERE p.usuario.idusuario = :usuarioId")
	List<Pet> findByUsuarioId(@Param("usuarioId") int usuarioId);
	
}
