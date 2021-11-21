package com.petcare.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class VeterinarioDto {

	private String idveterinario;
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 150, message = "Nome deve conter entre 3 e 150 caracteres.")
	private String nome;
	
	@Length(min = 2, max = 150, message = "Especialidade deve conter entre 2 e 150 caracteres.")
	@NotEmpty(message = "Especialidade não pode ser vazio.")
	private String especialidade;
	
	@Length(min = 8, max = 30, message = "Telefone deve conter entre 8 e 30 caracteres.")
	@NotEmpty(message = "Telefone não pode ser vazio.")
	private String telefone;
	
	@Length(min = 5, max = 200, message = "Endereço deve conter entre 5 e 200 caracteres.")
	@NotEmpty(message = "Endereço não pode ser vazio.")
	private String endereco;
	
	@NotEmpty(message = "O Id do Pet não pode ser vazio.")
	private String petId;
	
	public String getId() {
		return idveterinario;
	}
	
	public void setId(String idveterinario) {
		this.idveterinario = idveterinario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public String getPetId() {
		return petId;
	}
	
	public void setPetId(String petId) {
		this.petId = petId;
	}
	
	
	@Override
	public String toString() {
		return "Veterinario[id=" + idveterinario + ","
					+ "nome" + nome + ","
					+ "especialidade" + especialidade + ","
					+ "telefone" + telefone + ","
					+ "endereco" + endereco + ","
					+ "petId" + petId + "]";
	
	}
	
}
