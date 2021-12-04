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
@Table(name = "fichasaude")
public class Fichasaude implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//Colunas, conforme o banco de dados
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idficha;
	
	@Column(name = "nome_Saude", nullable = true, length = 100)
	private String nomeSaude;
	
	@Column(name = "data_Saude", nullable = true)
	private Date dataSaude;
	
	@Column(name = "hora_Saude", nullable = true)
	private Time horaSaude;
	
	@Column(name = "tipo_Saude", nullable = true, length = 1)
	private String tipoSaude;
	
	
	//Verificar relacionamentos
	
	// AJUSTAR RELACIONAMENTO
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	private Pet pet;
	
	
	// AJUSTAR RELACIONAMENTO
	//Verificar relacionamentos
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	private Veterinario veterinario;
	
	
	
	//Gets e Sets
	
	public int getId() {
		return idficha;
	}
	
	public void setId(int idficha) {
		this.idficha = idficha;
	}
	
	public String getNomeSaude() {
		return nomeSaude;
	}
	
	public void setNomeSaude(String nomeSaude) {
		this.nomeSaude = nomeSaude;
	}
	
	public Date getDataSaude() {
		return dataSaude;
	}
	
	public void setDataSaude (Date dataSaude) {
		this.dataSaude = dataSaude;
	}
	
	public Time getHoraSaude() {
		return horaSaude;
	}
	
	public void setHoraSaude(Time horaSaude) {
		this.horaSaude = horaSaude;
	}
	
	public String getTipoSaude() {
		return tipoSaude;
	}
	
	public void setTipoSaude(String tipoSaude) {
		this.tipoSaude = tipoSaude;
	}
	
	public Pet getPet() {
		return pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public Veterinario getVeterinario() {
		return veterinario;
	}
	
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	
	//Override toString
	
	@Override
	public String toString() {
		return "fichasaude[" + "id=" + idficha + ","
				+ "nomeSaude" + nomeSaude + ","
				+ "dataSaude" + dataSaude + ","
				+ "horaSaude" + horaSaude + ","
				+ "tipoSaude" + tipoSaude + ","
				+ "pet" + pet + ","
				+ "veterinario" + veterinario + "]";
		
	}
	
}