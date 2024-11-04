package com.Hotelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Hotelaria.controller.model.Hospede;
import com.Hotelaria.controller.model.repository.HospedeRepository;

@Controller
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping
    public String listarHospedes(Model model) {
        model.addAttribute("hospedes", hospedeRepository.findAll());
        return "hospedes/listar";
    }

    @GetMapping("/novo")
    public String novoHospedeForm(Model model) {
        model.addAttribute("hospede", new Hospede());
        return "hospedes/form";
    }

    @PostMapping
    public String salvarHospede(@ModelAttribute Hospede hospede) {
        HospedeRepository.save(hospede);
        return "redirect:/hospedes";
    }

	@SuppressWarnings("unused")
	private HospedeRepository getHospedeRepository() {
		return hospedeRepository;
	}

	@SuppressWarnings("unused")
	private void setHospedeRepository(final HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}
}
