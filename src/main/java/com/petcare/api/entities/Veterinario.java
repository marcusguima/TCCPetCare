package com.petcare.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "veterinario")
public class Veterinario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Colunas, conforme o Banco de Dados
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idveterinario;
	
	@Column(name = "nome", nullable = false, length = 150)
	private String nome;
	
	@Column(name = "especialidade", nullable = false, length = 150)
	private String especialidade;
	
	@Column(name = "telefone", nullable = false, length = 30)
	private String telefone;
	
	@Column(name = "endereco", nullable = false, length = 200)
	private String endereco;
	
//	@JsonBackReference
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinTable(name = "pet_veterinario",
//	joinColumns = { @JoinColumn(name = "pet_idpet")},
//	inverseJoinColumns = { @JoinColumn(name = "veterinario_idveterinario") })
//	private List<Pet> pets;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Pet pet;
	
	
	// Gets e Sets
	public int getId() {
		return idveterinario;
	}
	
	public void setId(int idveterinario) {
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
	
	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
	
	//Override ToString
	@Override
	public String toString() {
		return "veterinario[" + "idveterinario" + idveterinario + ","
				+ "nome" + nome + ","
				+ "especialidade" + especialidade + ","
				+ "telefone" + telefone + ","
				+ "endereco" + endereco + ","
				+ "pet" + pet + "]";
		
	}
	
}
