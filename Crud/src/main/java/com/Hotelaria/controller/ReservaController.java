package com.Hotelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hotelaria.controller.model.Reserva;
import com.Hotelaria.controller.model.repository.ReservaRepository;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;
    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        return "reservas/listar";
    }
    @GetMapping("/nova")
    public String novaReservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservas/form";
    }

    @PostMapping
    public String salvarReserva(@ModelAttribute Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String editarReservaForm(@PathVariable Long id, Model model) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        model.addAttribute("reserva", reserva);
        return "reservas/form";
    }

    @PostMapping("/editar/{id}")
    public String atualizarReserva(@PathVariable Long id, @ModelAttribute Reserva reservaAtualizada) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reserva.setInicio(reservaAtualizada.getInicio());
        reserva.setFim(reservaAtualizada.getFim());
        reserva.setDiaria(reservaAtualizada.getDiaria());
        reserva.setEstado(reservaAtualizada.getEstado());
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

	@GetMapping("/excluir/{id}")
    public String excluirReserva(@PathVariable Long id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas";
    }
}