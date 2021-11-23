package com.petcare.api.dtos;

public class DicainteracaoDto {

	private String dica;
	private String tipoDica;
	private String especieDica;
	
	public DicainteracaoDto() { }
	
	public DicainteracaoDto(String dica) {
		this.dica = dica;
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
	
	
	@Override
	public String toString() {
		return "Dicainteracao[dica=" + dica + ","
				+ "tipoDica" + tipoDica + ","
				+ "especieDica" + especieDica + "]";
	}
	
	
	
	
}
