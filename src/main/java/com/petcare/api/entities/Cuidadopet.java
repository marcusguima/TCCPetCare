package com.petcare.api.entities;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cuidadopet")
public class Cuidadopet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Colunas, conforme o banco de dados
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idcuidadopet;
	
	@Column(name = "data_Cuidado", nullable = true)
	private Date dataCuidado;
	
	@Column(name = "tipo_Cuidado", nullable = true, length = 1)
	private String tipoCuidado;
	
	@Column(name = "nome_Cuidado", nullable = true, length = 50)
	private String nomeCuidado;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	private Pet pet;
	
	
	
	//Gets e Sets
	
	public int getId() {
		return idcuidadopet;
	}
	
	public void setId(int idcuidadopet) {
		this.idcuidadopet = idcuidadopet;
	}
	
	public Date getDataCuidado() {
		return dataCuidado;
	}
	
	public void setDataCuidado(Date dataCuidado) {
		this.dataCuidado = dataCuidado;
	}
	
	public String getTipoCuidado() {
		return tipoCuidado;
	}
	
	public void setTipoCuidado (String tipoCuidado) {
		this.tipoCuidado = tipoCuidado;
	}
	
	public String getNomeCuidado() {
		return nomeCuidado;
	}
	
	public void setNomeCuidado(String nomeCuidado) {
		this.nomeCuidado = nomeCuidado;
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	//Override toString
	
	@Override
	public String toString() {
		return "cuidadopet[" + "idcuidadopet=" + idcuidadopet + ","
				+ "dataCuidado" + dataCuidado + ","
				+ "tipoCuidado" + tipoCuidado + ","
				+ "nomeCuidado" + nomeCuidado + ","
				+ "pet" + pet + "]";
		
	}
	
}