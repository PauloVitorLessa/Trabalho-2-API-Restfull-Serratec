package com.residencia.atividadeAPI.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@JsonIdentityInfo(
		scope = Telefone.class,
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idTelefone"
		)
@Entity
@Table (name = "telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Long idTelefone;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{11,11}")
	@Column (name = "numero")
	private String numero;	
	
	@OneToOne
	@JoinColumn (name = "id_instrutor" , referencedColumnName = "id", unique=true)
	private Instrutor instrutor;

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", instrutor=" + instrutor + "]";
	}
	

	
}
