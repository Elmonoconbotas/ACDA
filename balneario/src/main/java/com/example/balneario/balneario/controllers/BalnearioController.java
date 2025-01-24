package com.example.balneario.balneario.controllers;

import com.example.balneario.balneario.model.entity.Balneario;
import com.example.balneario.balneario.model.service.BalnearioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BalnearioController {
    @Autowired
    private BalnearioService balnearioService;

    @GetMapping("/balneario/addBalneario")
    public String balnearioForm(Model model){
        model.addAttribute("balneario", new Balneario());
        return "addBalneario";
    }

    @PostMapping("/balneario/addBalneario")
    public String balnearioSubmit(@ModelAttribute Balneario balneario, Model model){
        balnearioService.save(balneario);
        model.addAttribute("balneario", balneario);
        return "addBalneario";
    }

    @GetMapping("/balneario/verBarlenarios")
    public String allBalnearios(Model model){
        List<Balneario> balnearios = balnearioService.findAll();
        model.addAttribute("balnearios", balnearios);
        return "allBalnearios";
    }
    @GetMapping("/balneario/deleteBalnearios")
    public String delete(@ModelAttribute Balneario balneario, Model model) {
        balnearioService.delete(balneario.getCOD_B());
        return allBalnearios(model);
    }
}
