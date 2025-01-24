package com.example.paises.paises.controllers;

import com.example.paises.paises.model.entity.Capital;
import com.example.paises.paises.model.entity.Pais;
import com.example.paises.paises.model.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CapitalController {
    @Autowired
    CapitalService capitalService;

    @GetMapping("/capital/addCapital")
    private String capitalForm(Model model){
        model.addAttribute("capital", new Capital());
        return "addCapital";
    }

    @PostMapping("/capital/addCapital")
    private String capitalSubmit(@ModelAttribute Capital capital, Model model){
        capitalService.save(capital);
        model.addAttribute("capital", capital);
        return "addCapital";
    }
    @GetMapping("/capital/verCapitales")
    public String allCapitales(Model model){
        List<Capital> capitales = capitalService.findAll();
        model.addAttribute("capitales", capitales);
        return "allCapitales";
    }
    @GetMapping("/capital/deleteCapital")
    public String delete(@ModelAttribute Capital capital, Model model) {
        capitalService.delete(capital.getCOD_C());
        return allCapitales(model);
    }
}
