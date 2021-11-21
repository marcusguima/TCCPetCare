package com.petcare.api.entities;

import java.io.Serializable;
import java.util.List;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Colunas, conforme o Banco de Dados
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idusuario;
	
	@Column(name = "nome", nullable = false, length = 150)
	private String nome;
	
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;
	
	@Column(name = "senha", nullable = false, length = 30)
	private String senha;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pet> pets;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_dicainteracao",
				joinColumns = { @JoinColumn(name = "usuario_idusuario")},
				inverseJoinColumns = { @JoinColumn(name = "dicainteracao_iddica") })
	private List<Dicainteracao> dicasinteracao;
	
	
	// Gets e Sets
	public int getId() {
		return idusuario;
	}
	
	public void setId(int idusuario) {
		this.idusuario = idusuario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public  List<Pet> getPets(){
		return pets;
	}
	
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	public List<Dicainteracao> getDicasinteracao() {
		return dicasinteracao;
	}
	
	public void setDicasinteracao(List<Dicainteracao> dicasinteracao) {
		this.dicasinteracao = dicasinteracao;
	}
	
	//Override ToString
	
	@Override
	public String toString() {
		return "usuario[" + "id=" + idusuario + ","
				+ "nome=" + nome + ","
				+ "email" + email + ","
				+ "senha" + senha + "]";
	}
	
	
}
