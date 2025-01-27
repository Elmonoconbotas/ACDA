package com.example.autobuses.autobuses.controllers;

import com.example.autobuses.autobuses.model.entity.Conductor;
import com.example.autobuses.autobuses.model.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("conductores")
public class ConductorController {
    @Autowired
    private ConductorService conductorService;

    @GetMapping({ "", "/" })
    public String index(Model model) {
        List<Conductor> conductores = conductorService.findAll();
        model.addAttribute("conductores", conductores);
        return "conductores/listar_conductores";
    }

    @GetMapping("/guardar")
    public String guardar(@RequestParam(name ="id", required = false) Integer id, Model model) {
        Conductor conductor = new Conductor();
        if (id != null) {
            conductor = conductorService.findById(id);
            model.addAttribute("editar", true);
        }
        model.addAttribute("conductor", conductor);
        return "conductores/guardar_conductores";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Conductor conductor, Model model) {
        conductorService.save(conductor);
        return "redirect:/conductores";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(name ="id") Integer id, Model model) {
        Conductor conductor = conductorService.findById(id);
        conductorService.delete(conductor);
        return "redirect:/conductores";
    }
}
