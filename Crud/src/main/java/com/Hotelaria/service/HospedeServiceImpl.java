package com.Hotelaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotelaria.controller.model.Hospede;
import com.Hotelaria.controller.model.repository.HospedeRepository;

@Service
public class HospedeServiceImpl implements HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    @Override
    public List<Hospede> listarTodosHospedes() {
        return hospedeRepository.findAll();
    }

    @Override
    public Hospede buscarHospedePorId(Long id) {
        Optional<Hospede> hospede = hospedeRepository.findById(id);
        return hospede.orElse(null);  // Retorna null se não encontrar o hospede
    }

    @Override
    public Hospede salvarHospede(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @Override
    public void excluirHospede(Long id) {
        hospedeRepository.deleteById(id);
    }
}
