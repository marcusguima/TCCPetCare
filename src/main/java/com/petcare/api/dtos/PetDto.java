package com.petcare.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class PetDto {

	private String idpet;
	
	@NotEmpty(message = "Espécie não pode ser vazio.")
	@Length(min = 3, max = 45, message = "Espécie deve conter entre 3 e 45 caracteres.")
	private String especie;
	
	@Length(min = 2, max = 100, message = "Nome deve conter entre 2 e 100 caracteres.")
	@NotEmpty(message = "Nome não pode ser vazio.")
	private String nome;
	
	@NotEmpty(message = "Data de Nascimento não pode ser vazio.")
	private String dtNascimento;
	
	@Length(min = 3, max = 45, message = "Raça deve conter entre 3 e 45 caracteres.")
	private String raca;
	
	@Length(min = 4, max = 45, message = "Sexo deve conter entre 4 e 45 caracteres.")
	@NotEmpty(message = "Sexo não pode ser vazio.")
	private String sexo;
	
	private String peso;
	
	@NotEmpty(message = "O ID do Usuário não pode ser vazio.")
	private String usuarioId;
	
	public String getId() {
		return idpet;
	}
	
	public void setId(String idpet) {
		this.idpet = idpet;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	public String getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	@Override
	public String toString() {
		return "Pet[id=" + idpet + ","
					+ "especie" + especie + ","
					+ "nome" + nome + ","
					+ "dtNascimento" + dtNascimento + ","
					+ "raca" + raca + ","
					+ "sexo" + sexo + ","
					+ "peso" + peso + ","
					+ "usuarioId" + usuarioId + "]";
	
	}
	
}
