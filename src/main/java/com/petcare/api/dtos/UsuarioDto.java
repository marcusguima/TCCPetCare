package com.petcare.api.dtos;


import javax.validation.constraints.NotEmpty;

import java.util.List;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class UsuarioDto {
	
	private String idusuario;
	
	@NotEmpty(message = "Email não pode ser vazio.")
	@Email(message = "Email inválido.")
	private String email;
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 150, message = "Nome deve conter entre 3 e 150 caracteres.")
	private String nome;
	
	@NotEmpty(message = "Senha não pode ser vazio.")
	@Length(min = 4, max = 30, message = "Senha deve conter entre 4 e 30 caracteres.")
	private String senha;
	
	private List<DicainteracaoDto> dicasinteracao;
	
	
	public String getId() {
		return idusuario;
	}
	
	public void setId(String idusuario) {
		this.idusuario = idusuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<DicainteracaoDto> getDicasinteracao(){
		return dicasinteracao;
	}
	
	public void setDicasinteracao(List<DicainteracaoDto> dicasinteracao) {
		this.dicasinteracao = dicasinteracao;
	}
	

	@Override
	public String toString() {
		return "Usuario[id=" + idusuario + ","
					+ "email=" + email + ","
					+ "nome=" + nome + ","
					+ "senha" + senha + "]";
	}
	

}
