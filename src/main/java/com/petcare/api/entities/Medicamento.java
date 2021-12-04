package com.petcare.api.entities;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name = "medicamento")
public class Medicamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Colunas, conforme o banco de dados
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idmedicamento;
	
	// nome_Med string 50
	@Column(name = "nome_Med", nullable = false, length = 50)
	private String nomeMed;
	
	// finalidade_Med string 200 not null true
	@Column(name = "finalidade_Med", nullable = true, length = 200)
	private String finalidadeMed;
	
	// dose_Med string 50
	@Column(name = "dose_Med", nullable = false, length = 50)
	private String doseMed;
	
	// hora_Aplicacao time
	@Column(name = "hora_Aplicacao", nullable = false)
	private Time horaAplicacao;
	
	
	// intervalo int
	@Column(name = "intervalo", nullable = false)
	private int intervalo;
	
	
	// data_Inicial Date
	@Column(name = "data_Inicial", nullable = false)
	private Date dataInicial;
	
	// data_Final Date
	@Column(name = "data_Final", nullable = false)
	private Date dataFinal;
	
	
	
	// Ficha Saude = fichasaude
	// VERIFICAR CARDINALIDADE
	// AJUSTAR RELACIONAMENTO
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	private Fichasaude fichasaude;
	
	
	
	//Gets e Sets
	
	public int getId() {
		return idmedicamento;
	}
	
	public void setId(int idmedicamento) {
		this.idmedicamento = idmedicamento;
	}
	
	public String getNomeMed() {
		return nomeMed;
	}
	
	public void setNomeMed(String nomeMed) {
		this.nomeMed = nomeMed;
	}
	
	public String getFinalidadeMed() {
		return finalidadeMed;
	}
	
	public void setFinalidadeMed (String finalidadeMed) {
		this.finalidadeMed = finalidadeMed;
	}
	
	public String getDoseMed() {
		return doseMed;
	}
	
	public void setDoseMed(String doseMed) {
		this.doseMed = doseMed;
	}
	
	public Time getHoraAplicacao() {
		return horaAplicacao;
	}
	
	public void setHoraAplicacao(Time horaAplicacao) {
		this.horaAplicacao = horaAplicacao;
	}
	
	public int getIntervalo() {
		return intervalo;
	}
	
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	public Fichasaude getFichasaude() {
		return fichasaude;
	}
	
	public void setFichasaude(Fichasaude fichasaude) {
		this.fichasaude = fichasaude;
	}
	
	
	
	//Override toString
	@Override
	public String toString() {
		return "medicamento[" + "id=" + idmedicamento + ","
				+ "nomeMed" + nomeMed + ","
				+ "finalidadeMed" + finalidadeMed + ","
				+ "doseMed" + doseMed + ","
				+ "horaAplicacao" + horaAplicacao + ","
				+ "intervalo" + intervalo + ","
				+ "dataInicial" + dataInicial + ","
				+ "dataFinal" + dataFinal + ","
				+ "fichasaude" + fichasaude + "]";
		
	}
	
}
