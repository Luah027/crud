package com.Hotelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Hotelaria.controller.model.Hospede;
import com.Hotelaria.controller.model.repository.HospedeRepository;

@Controller
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping ("/listar")
    public String listarHospedes(Model model) {
        model.addAttribute("hospedes", hospedeRepository.findAll());
        System.out.println("listar");
        return "hospedes/listar";
    }

    @GetMapping("/novo")
    public String novoHospedeForm(Model model) {
        model.addAttribute("hospede", new Hospede());
        return "index";
    }

    @PostMapping
    public String salvarHospede(@ModelAttribute Hospede hospede) {
        hospedeRepository.save(hospede);
        return "redirect:/hospedes";
    }
    @GetMapping("/editar/{id}")
    public String editarHospedeForm(@PathVariable Long id, Model model) {
        Hospede hospede = hospedeRepository.findById(id).orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));
        model.addAttribute("hospede", hospede);
        return "hospedes/form";
    }
    
    @PostMapping("/editar/{id}")
    public String atualizarHospede(@PathVariable Long id, @ModelAttribute Hospede hospedeAtualizado) {
        Hospede hospede = hospedeRepository.findById(id).orElseThrow(() -> new RuntimeException("Hóspede não encontrado"));
        hospede.setNumDocumento(hospedeAtualizado.getNumDocumento());
        hospede.setDataNascimento(hospedeAtualizado.getDataNascimento());
        hospedeRepository.save(hospede);
        return "redirect:/hospedes";
    }
    @GetMapping("/excluir/{id}")
    public String excluirHospede(@PathVariable Long id) {
        hospedeRepository.deleteById(id);
        return "redirect:/hospedes";
    }
}
