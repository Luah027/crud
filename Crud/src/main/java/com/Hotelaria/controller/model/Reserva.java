package com.Hotelaria.controller.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A data de início é obrigatória.")
    private LocalDateTime inicio;

    @NotBlank(message = "A data de fim é obrigatória.")
    private LocalDateTime fim;

    @NotBlank(message = "O valor da diária é obrigatório.")
    private Double diaria;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @ManyToOne
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    // Método para calcular a duração da estadia
    public int calcularDuracao() {
        return (int) java.time.Duration.between(inicio, fim).toDays();
    }

	public Object getInicio() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setInicio(Object inicio2) {
		// TODO Auto-generated method stub
		
	}

	public Object getFim() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDiaria() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFim(Object fim2) {
		// TODO Auto-generated method stub
		
	}

	public void setDiaria(Object diaria2) {
		// TODO Auto-generated method stub
		
	}

	public Object getEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEstado(Object estado2) {
		// TODO Auto-generated method stub
		
	}

    // Getters e Setters
}
