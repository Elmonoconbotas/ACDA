package com.example.balneario.balneario.controllers;

import com.example.balneario.balneario.model.entity.Tratamiento;
import com.example.balneario.balneario.model.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TratamientoController {
    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/tratamiento/addTratamiento")
    public String tratamientoForm(Model model){
        model.addAttribute("tratamiento", new Tratamiento());
        return "addTratamiento";
    }

    @PostMapping("/tratamiento/addTratamiento")
    public String tratamientoSubmit(@ModelAttribute Tratamiento tratamiento, Model model){
        tratamientoService.save(tratamiento);
        model.addAttribute("tratamiento", tratamiento);
        return "addTratamiento";
    }

    @GetMapping("/tratamiento/verTratamientos")
    public String allTratamientos(Model model){
        List<Tratamiento> tratamientos = tratamientoService.findAll();
        model.addAttribute("tratamientos", tratamientos);
        return "allTratamientos";
    }
    @GetMapping("/tratamiento/deleteTratamiento")
    public String delete(@ModelAttribute Tratamiento tratamiento, Model model) {
        tratamientoService.delete(tratamiento.getCOD_T());
        return allTratamientos(model);
    }
}
