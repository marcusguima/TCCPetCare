package com.petcare.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CuidadopetDto {

	// Id cuidadopet INT NOT NULL AUTO_INCREMENT
	private String idcuidadopet;
	
	// dataCuidado (data_Cuidado) DATE
	@NotEmpty(message = "A Data do Cuidado não pode ser vazia.")
	private String dataCuidado;
	
	// tipoCuidado (tipo_Cuidado) STRING 1
	@Length(min = 1, max = 1, message = "Tipo do Cuidado deve conter 1 caracter.")
	@NotEmpty(message = "Tipo do Cuidado não pode ser vazio.")
	private String tipoCuidado;
	
	// nomeCuidado (nome_Cuidado)  STRING 50
	@Length(min = 3, max = 50, message = "Nome do Cuidado deve conter entre 3 e 50 caracteres.")
	@NotEmpty(message = "Nome do Cuidado não pode ser vazio.")
	private String nomeCuidado;
	
	// ID DO PET - CHAVE ESTRANGEIRA - INT NOT NULL
	@NotEmpty(message = "O ID do PET não pode ser vazio.")
	private String petId;
	
	public String getId() {
		return idcuidadopet;
	}
	
	public void setId(String idcuidadopet) {
		this.idcuidadopet = idcuidadopet;
	}
	
	public String getDataCuidado() {
		return dataCuidado;
	}
	
	public void setDataCuidado(String dataCuidado) {
		this.dataCuidado = dataCuidado;
	}
	
	public String getTipoCuidado() {
		return tipoCuidado;
	}
	
	public void setTipoCuidado(String tipoCuidado) {
		this.tipoCuidado = tipoCuidado;
	}
	
	public String getNomeCuidado() {
		return nomeCuidado;
	}
	
	public void setNomeCuidado(String nomeCuidado) {
		this.nomeCuidado = nomeCuidado;
	}
	
	public String getPetId() {
		return petId;
	}
	
	public void setPetId(String petId) {
		this.petId = petId;
	}
	
	@Override
	public String toString() {
		return "Cuidadopet[id=" + idcuidadopet + ","
					+ "dataCuidado" + dataCuidado + ","
					+ "tipoCuidado" + tipoCuidado + ","
					+ "nomeCuidado" + nomeCuidado + ","
					+ "petId" + petId + "]";
	
	}
	
}
