package com.Hotelaria.controller.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hospede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@NotBlank(message = "O nome do hospede é obrigatório.")
    private String nome;
    
    @NotBlank(message = "A data de nascimento é obrigatória.")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "hospede", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

	public Object getNumDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDataNascimento() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNumDocumento(Object numDocumento2) {
		// TODO Auto-generated method stub
		
	}

	public void setDataNascimento(Object dataNascimento2) {
		// TODO Auto-generated method stub
		
	}

    // Getters e Setters
}
