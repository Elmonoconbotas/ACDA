package es.mariana.acda.ut4.ejemplorelacion1n.controller;

import es.mariana.acda.ut4.ejemplorelacion1n.model.entity.Persona;
import es.mariana.acda.ut4.ejemplorelacion1n.model.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping({ "", "/" })
    public String index(Model model) {
        List<Persona> personas = personaService.findAllWithCoches();
        model.addAttribute("personas", personas);
        return "personas/listar_personas";
    }

    @GetMapping("/guardar")
    public String guardar(@RequestParam(name ="id", required = false) Integer id, Model model) {
        Persona persona = new Persona();
        if (id != null) {
            persona = personaService.findById(id);
            model.addAttribute("editar", true);
        }
        model.addAttribute("persona", persona);
        return "personas/guardar_persona";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Persona persona, Model model) {
        personaService.save(persona);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(name ="id") Integer id, Model model) {
        Persona persona = personaService.findById(id);
        personaService.delete(persona);
        return "redirect:/personas";
    }
}
