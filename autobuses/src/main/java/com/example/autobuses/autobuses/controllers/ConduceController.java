package com.example.autobuses.autobuses.controllers;


import com.example.autobuses.autobuses.model.entity.Autobus;
import com.example.autobuses.autobuses.model.entity.Conduce;
import com.example.autobuses.autobuses.model.entity.ConduceID;
import com.example.autobuses.autobuses.model.entity.Conductor;
import com.example.autobuses.autobuses.model.service.AutobusService;
import com.example.autobuses.autobuses.model.service.ConduceService;
import com.example.autobuses.autobuses.model.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("conducciones")
public class ConduceController {
    @Autowired
    private ConduceService conduceService;
    @Autowired
    private ConductorService conductorService;
    @Autowired
    private AutobusService autobusService;

    @GetMapping({ "", "/" })
    public String index(Model model) {
        List<Conduce> conducciones = conduceService.findAll();
        model.addAttribute("conducciones", conducciones);
        return "conducciones/listar_conducciones";
    }

    @GetMapping("/guardar")
    public String guardar(@RequestParam(name = "autobusID", required = false) Integer autobusID,
                          @RequestParam(name = "conductorID", required = false) Integer conductorID, Model model) {
        List<Conductor> conductores = conductorService.findAll();
        List<Autobus> autobuses = autobusService.findAll();
        if (conductores.isEmpty()) {
            model.addAttribute("sinConductores", true);
            return "conducciones/guardar_conducciones";
        }
        if(autobuses.isEmpty()){
            model.addAttribute("sinAutobuses", true);
            return "conducciones/guardar_conducciones";
        }
        model.addAttribute("sinConductores", false);
        model.addAttribute("conductores", conductores);
        model.addAttribute("sinAutobuses", false);
        model.addAttribute("autobuses", autobuses);
        Conduce conduccion = new Conduce();
        if (autobusID != null && conductorID != null) {
            ConduceID conduceID = new ConduceID(conductorID, autobusID);
            conduccion = conduceService.findById(conduceID);
            model.addAttribute("editar", true);
        }
        model.addAttribute("conduccion", conduccion);
        return "conducciones/guardar_conducciones";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Conduce conduccion, Model model) {
        /*if () {
            model.addAttribute("error_existe", true);
            return guardar(conduccion.getConduceID().getAutobusID(), conduccion.getConduceID().getConductorID(), model);
        }
        conduceService.delete(conduccion.getConduceID());
        /*
        ConduceID conduceID = new ConduceID(conduccion.getAutobus().getAutobusID(), conduccion.getConductor().getConductorID());
        conduccion.setConduceID(conduceID);
         */

        conduceService.save(conduccion);
        return "redirect:/conducciones";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam Integer autobusID, @RequestParam Integer conductorID, Model model) {
        ConduceID conduceID = new ConduceID(conductorID, autobusID);
        Conduce conduccion = conduceService.findById(conduceID);
        conduceService.delete(conduccion.getConduceID());
        return "redirect:/conducciones";
    }
}
