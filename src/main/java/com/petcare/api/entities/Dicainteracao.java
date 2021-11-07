package com.petcare.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "dicainteracao")
public class Dicainteracao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Colunas, conforme o Banco de Dados
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int iddica;
	
	@Lob
	@Column(name = "dica", nullable = true, length = 2000)
	private String dica;
	
	
	@Column(name = "tipo_Dica", nullable = true, length = 1)
	private String tipoDica;
	
	@Column(name = "especie_Dica", nullable = true, length = 1)
	private String especieDica;
	
	// Gets e Sets
	public int getId() {
		return iddica;
	}
	
	public void setId(int iddica) {
		this.iddica = iddica;
	}
	
	public String getDica() {
		return dica;
	}
	
	public void setDica(String dica) {
		this.dica = dica;
	}
	
	public String getTipoDica() {
		return tipoDica;
	}
	
	public void setTipoDica(String tipoDica) {
		this.tipoDica = tipoDica;
	}
	
	public String getEspecieDica() {
		return especieDica;
	}
	
	public void setEspecieDica(String especieDica) {
		this.especieDica = especieDica;
	}
	
	//Override ToString
	@Override
	public String toString() {
		return "Dicainteracao[id=" + iddica + ","
				+ "dica" + dica + ","
				+ "tipoDica" + tipoDica + ","
				+ "especieDica" + especieDica + "]";
		
	}
	
	
}
