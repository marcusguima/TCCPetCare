package com.petcare.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.petcare.api.dtos.UsuarioDto;
import com.petcare.api.entities.Usuario;
import com.petcare.api.dtos.PetDto;
import com.petcare.api.entities.Pet;
import com.petcare.api.dtos.VeterinarioDto;
import com.petcare.api.entities.Veterinario;

public class ConversaoUtils {

	public static Veterinario Converter(VeterinarioDto veterinarioDto) throws ParseException {
		
		Veterinario veterinario = new Veterinario();
		
		if(veterinarioDto.getId() != null && veterinarioDto.getId() != "")
			veterinario.setId(Integer.parseInt(veterinarioDto.getId()));
		
		veterinario.setNome(veterinario.getNome());
		veterinario.setEspecialidade(veterinario.getEspecialidade());
		veterinario.setTelefone(veterinario.getTelefone());
		veterinario.setEndereco(veterinario.getEndereco());
		
		Pet pet = new Pet();
		pet.setId(Integer.parseInt(veterinarioDto.getPetId()));
		
		veterinario.setPet(pet);
		
		return veterinario;
		
	}
	
	public static VeterinarioDto Converter(Veterinario veterinario) {
		
		VeterinarioDto veterinarioDto = new VeterinarioDto();
		
		veterinarioDto.setId(String.valueOf(veterinario.getId()));
		veterinarioDto.setNome(veterinario.getNome());
		veterinarioDto.setEspecialidade(veterinario.getEspecialidade());
		veterinarioDto.setTelefone(veterinario.getTelefone());
		veterinarioDto.setEndereco(veterinario.getEndereco());
		veterinarioDto.setPetId(String.valueOf(veterinario.getPet().getId()));
		
		return veterinarioDto;
		
	}

	public static List<VeterinarioDto> ConverterListaVet(List<Veterinario> lista) {
	
		List<VeterinarioDto> lst = new ArrayList<VeterinarioDto>(lista.size());
	
		for(Veterinario veterinario : lista) {
			lst.add(Converter(veterinario));
		}
	
		return lst;
	
	}

	
	public static Pet Converter(PetDto petDto) throws ParseException {
		
		Pet pet = new Pet();
		
		if(petDto.getId() != null && petDto.getId() != "")
			pet.setId(Integer.parseInt(petDto.getId()));
		
		pet.setEspecie(petDto.getEspecie());
		pet.setNome(petDto.getNome());
		pet.setDtNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(petDto.getDtNascimento()));
		pet.setRaca(petDto.getRaca());
		pet.setSexo(petDto.getSexo());
		pet.setPeso(Integer.parseInt(petDto.getPeso()));
		
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(petDto.getUsuarioId()));
		
		pet.setUsuario(usuario);
		
		return pet;
		
	}
	
	public static PetDto Converter(Pet pet) {
		
		PetDto petDto = new PetDto();
		
		petDto.setId(String.valueOf(pet.getId()));
		petDto.setEspecie(pet.getEspecie());
		petDto.setNome(pet.getNome());
		petDto.setDtNascimento(pet.getDtNascimento().toString());
		petDto.setRaca(pet.getRaca());
		petDto.setSexo(pet.getSexo());
		petDto.setPeso(String.valueOf(pet.getPeso()));
		petDto.setUsuarioId(String.valueOf(pet.getUsuario().getId()));
		
		return petDto;
		
	}
	
	public static List<PetDto> ConverterLista(List<Pet> lista) {
		
		List<PetDto> lst = new ArrayList<PetDto>(lista.size());
		
		for(Pet pet : lista) {
			lst.add(Converter(pet));
		}
		
		return lst;
		
	}
	
	
	public static Usuario Converter(UsuarioDto usuarioDto) {
		
		Usuario usuario = new Usuario();
		
		if (usuarioDto.getId() != null && usuarioDto.getId() != "")
			usuario.setId(Integer.parseInt(usuarioDto.getId()));
		
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(usuarioDto.getSenha());
		
		return usuario;
		
	}
	
	public static UsuarioDto Converter (Usuario usuario) {
	
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setId(String.valueOf(usuario.getId()));
		usuarioDto.setNome(usuario.getNome());
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setSenha(usuario.getSenha());
		
		return usuarioDto;
			
	}
	
	
}
