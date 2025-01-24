package es.mariana.acda.ut4.ejemplorelacion1n.controller;

import es.mariana.acda.ut4.ejemplorelacion1n.model.entity.Coche;
import es.mariana.acda.ut4.ejemplorelacion1n.model.entity.Persona;
import es.mariana.acda.ut4.ejemplorelacion1n.model.service.CocheService;
import es.mariana.acda.ut4.ejemplorelacion1n.model.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("coches")
public class CocheController {

    @Autowired
    private CocheService cocheService;

    @Autowired
    private PersonaService personaService;

    @GetMapping({ "", "/" })
    public String index(Model model) {
        List<Coche> coches = cocheService.findAll();
        model.addAttribute("coches", coches);
        return "coches/listar_coches";
    }

    @GetMapping("/guardar")
    public String guardar(@RequestParam(name ="id", required = false) Integer id, Model model) {
        List<Persona> personas = personaService.findAll();
        if (personas.isEmpty()) {
            model.addAttribute("sinPersonas", true);
            return "coches/guardar_coche";
        }
        model.addAttribute("sinPersonas", false);
        model.addAttribute("personas", personas);

        Coche coche = new Coche();
        if (id != null) {
            coche = cocheService.findById(id);
            model.addAttribute("editar", true);
        }
        model.addAttribute("coche", coche);
        return "coches/guardar_coche";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Coche coche, Model model) {
        cocheService.save(coche);
        return "redirect:/coches";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(name ="id") Integer id, Model model) {
        Coche coche = cocheService.findById(id);
        cocheService.delete(coche);
        return "redirect:/coches";
    }
}
