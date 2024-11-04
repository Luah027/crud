package com.Hotelaria.controller;

import com.Hotelaria.controller.model.Reserva;
import com.Hotelaria.controller.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
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
}