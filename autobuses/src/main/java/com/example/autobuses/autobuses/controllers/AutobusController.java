package com.example.autobuses.autobuses.controllers;

import com.example.autobuses.autobuses.model.entity.Autobus;
import com.example.autobuses.autobuses.model.service.AutobusService;
import com.example.autobuses.autobuses.model.service.ConduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("autobuses")
public class AutobusController {
    @Autowired
    private AutobusService autobusService;

    @Autowired
    private ConduceService conduccionesService;

    @GetMapping({ "", "/" })
    public String index(Model model) {
        List<Autobus> autobuses = autobusService.findAll();
        model.addAttribute("autobuses", autobuses);
        return "autobuses/listar_autobuses";
    }

    @GetMapping("/guardar")
    public String guardar(@RequestParam(name ="id", required = false) Integer id, Model model) {
        Autobus autobus = new Autobus();
        if (id != null) {
            autobus = autobusService.findById(id);
            model.addAttribute("editar", true);
        }
        model.addAttribute("autobus", autobus);
        return "autobuses/guardar_autobuses";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Autobus autobus, Model model) {
        autobusService.save(autobus);
        return "redirect:/autobuses";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(name ="id") Integer id, Model model) {
        Autobus autobus = autobusService.findById(id);
        autobusService.delete(autobus);
        return "redirect:/autobuses";
    }
}
