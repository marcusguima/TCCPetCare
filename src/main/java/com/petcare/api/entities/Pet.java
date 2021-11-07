package com.petcare.api.entities;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pet")
public class Pet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Colunas, conforme o banco de dados
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idpet;
	
	@Column(name = "especie", nullable = false, length = 45)
	private String especie;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "dt_Nascimento", nullable = false)
	private Date dtNascimento;
	
	@Column(name = "raca", nullable = true, length = 45)
	private String raca;
	
	@Column(name = "sexo", nullable = false, length = 45)
	private String sexo;
	
	@Column(name = "peso", nullable = true)
	private int peso;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	private Cuidadopet cuidadopet;
	
	
	
	//Gets e Sets
	
	public int getId() {
		return idpet;
	}
	
	public void setId(int idpet) {
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
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(Date dtNascimento) {
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
	
	public int getPeso() {
		return peso;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Cuidadopet getCuidadoPet() {
		return cuidadopet;
	}
	
	public void setCuidadoPet(Cuidadopet cuidadopet) {
		this.cuidadopet = cuidadopet;
	}
	
	//Override toString
	
	@Override
	public String toString() {
		return "pet[" + "idpet=" + idpet + ","
				+ "especie" + especie + ","
				+ "nome" + nome + ","
				+ "dtNascimento" + dtNascimento + ","
				+ "raca" + raca + ","
				+ "sexo" + sexo + ","
				+ "peso" + peso + ","
				+ "usuario" + usuario + "]";
		
	}
	
}
