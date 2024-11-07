package com.Hotelaria.service;

import java.util.List;

import com.Hotelaria.controller.model.Hospede;

public interface HospedeService {
    List<Hospede> listarTodosHospedes();
    Hospede buscarHospedePorId(Long id);
    Hospede salvarHospede(Hospede hospede);
    void excluirHospede(Long id);
}