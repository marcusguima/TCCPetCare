package com.petcare.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.petcare.api.dtos.UsuarioDto;
import com.petcare.api.entities.Usuario;
import com.petcare.api.dtos.DicainteracaoDto;
import com.petcare.api.dtos.PetDto;
import com.petcare.api.entities.Dicainteracao;
import com.petcare.api.entities.Pet;
import com.petcare.api.dtos.VeterinarioDto;
import com.petcare.api.entities.Veterinario;
import com.petcare.api.entities.Cuidadopet;
import com.petcare.api.dtos.CuidadopetDto;

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
		
		if (usuarioDto.getDicasinteracao() != null && usuarioDto.getDicasinteracao().size() > 0) {
			
			usuario.setDicasinteracao(new ArrayList<Dicainteracao>());
			
			for (DicainteracaoDto dicainteracaoDto : usuarioDto.getDicasinteracao()) {
				
				Dicainteracao dicainteracao = new Dicainteracao();
				dicainteracao.setDica(dicainteracaoDto.getDica());
				
				usuario.getDicasinteracao().add(dicainteracao);
				
			}
			
		}
		
		return usuario;
		
		
	}
	
	public static UsuarioDto Converter (Usuario usuario) {
	
		UsuarioDto usuarioDto = new UsuarioDto();
		
		usuarioDto.setId(String.valueOf(usuario.getId()));
		usuarioDto.setNome(usuario.getNome());
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setSenha(usuario.getSenha());
		
		if(usuario.getDicasinteracao() != null) {
			
			usuarioDto.setDicasinteracao(new ArrayList<DicainteracaoDto>());
			
			for(int i = 0; i < usuario.getDicasinteracao().size(); i++) {
				
				DicainteracaoDto dicainteracaoDto = new DicainteracaoDto();
				
				dicainteracaoDto.setDica(usuario.getDicasinteracao().get(i).getDica());
				dicainteracaoDto.setTipoDica(usuario.getDicasinteracao().get(i).getTipoDica());
				dicainteracaoDto.setEspecieDica(usuario.getDicasinteracao().get(i).getEspecieDica());
				
			}
			
		}
		
		return usuarioDto;
			
	}
	
	
	public static DicainteracaoDto Converter(Dicainteracao dicainteracao) {
		
		DicainteracaoDto dicainteracaoDto = new DicainteracaoDto();
		
		dicainteracaoDto.setDica(dicainteracao.getDica());
		dicainteracaoDto.setTipoDica(dicainteracao.getTipoDica());
		dicainteracaoDto.setEspecieDica(dicainteracao.getEspecieDica());
		
		return dicainteracaoDto;
		
	}
	
	
	
	public static List<DicainteracaoDto> Converter (List<Dicainteracao> dicasinteracao){
		
		List<DicainteracaoDto> dicasinteracaoDto = new ArrayList<DicainteracaoDto>();
		
		for (Dicainteracao dicainteracao : dicasinteracao)
			dicasinteracaoDto.add(Converter(dicainteracao));
		
		return dicasinteracaoDto;
		
	}
	
	// * REMOVER TRECHO DE CÓDIGO NAO UTILIZADO*
//	public static List<DicainteracaoDto> ConverterListaDicas(List<Dicainteracao> listaDicas) {
//		
//		List<DicainteracaoDto> lst = new ArrayList<DicainteracaoDto>(listaDicas.size());
//		
//		for(Dicainteracao dicainteracao : listaDicas) {
//			lst.add(Converter(dicainteracao));
//		}
//		
//		return lst;
//		
//	}
	// * REMOVER TRECHO DE CÓDIGO NAO UTILIZADO*
	
	
	// Converter Lista
	
	
	
	
	
	// Converter - SALVAR
	
		public static Cuidadopet Converter(CuidadopetDto cuidadopetDto) throws ParseException {
		
		Cuidadopet cuidadopet = new Cuidadopet();
		
		if(cuidadopetDto.getId() != null && cuidadopetDto.getId() != "")
			cuidadopet.setId(Integer.parseInt(cuidadopetDto.getId()));
		
		cuidadopet.setDataCuidado(new SimpleDateFormat("dd/MM/yyyy").parse(cuidadopetDto.getDataCuidado()));
		cuidadopet.setTipoCuidado(cuidadopetDto.getTipoCuidado());
		cuidadopet.setNomeCuidado(cuidadopetDto.getNomeCuidado());
		
		Pet pet = new Pet();
		pet.setId(Integer.parseInt(cuidadopetDto.getPetId()));
		
		cuidadopet.setPet(pet);
		
		return cuidadopet;
		
	}
	
	public static CuidadopetDto Converter(Cuidadopet cuidadopet) {
		
		CuidadopetDto cuidadopetDto = new CuidadopetDto();
		
		cuidadopetDto.setId(String.valueOf(cuidadopet.getId()));
		cuidadopetDto.setDataCuidado(cuidadopet.getDataCuidado().toString());
		cuidadopetDto.setTipoCuidado(cuidadopet.getTipoCuidado());
		cuidadopetDto.setNomeCuidado(cuidadopet.getNomeCuidado());
		cuidadopetDto.setPetId(String.valueOf(cuidadopet.getPet().getId()));
		
		return cuidadopetDto;
		
	}
	
	public static List<CuidadopetDto> ConverterListaCuidado(List<Cuidadopet> listaCuidados) {
		
		List<CuidadopetDto> lst = new ArrayList<CuidadopetDto>(listaCuidados.size());
		
		for(Cuidadopet cuidadopet : listaCuidados) {
			lst.add(Converter(cuidadopet));
		}
		
		return lst;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
