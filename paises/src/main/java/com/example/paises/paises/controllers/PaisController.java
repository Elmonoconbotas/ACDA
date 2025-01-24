package com.example.paises.paises.controllers;

import com.example.paises.paises.model.entity.Pais;
import com.example.paises.paises.model.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("/pais/addPais")
    public String paisForm(Model model){
        model.addAttribute("pais", new Pais());
        return "addPais";
    }

    @PostMapping("/pais/addPais")
    public String paisSubmit(@ModelAttribute Pais pais, Model model){
        paisService.save(pais);
        model.addAttribute("pais", pais);
        return "addPais";
    }

    @GetMapping("/pais/verPaises")
    public String allPaises(Model model){
        List<Pais> paises = paisService.findAll();
        model.addAttribute("paises", paises);
        return "allPaises";
    }
    @GetMapping("/pais/deletePais")
    public String delete(@ModelAttribute Pais pais, Model model) {
        paisService.delete(pais.getCOD_P());
        return allPaises(model);
    }
}
