package es.mariana.mikel.Mikel.controller;

import es.mariana.mikel.Mikel.model.dao.IVideojuegoDAO;
import es.mariana.mikel.Mikel.model.entity.Videojuego;
import es.mariana.mikel.Mikel.model.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping("/videojuegos")
    public String videojuegos(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "plataforma", required = false) String plataforma,
            Model model) {

        if (nombre == null)
            nombre = "Mikel";
        if (plataforma == null)
            plataforma = "";

        Videojuego videojuego = new Videojuego();
        videojuego.setNombre(nombre);
        videojuego.setPlataforma(plataforma);
        videojuegoService.save(videojuego);

        model.addAttribute("nombre", nombre);
        model.addAttribute("plataforma", plataforma);
        return "videojuegos";
    }

    @GetMapping("/videojuegos/all")
    public String all(Model model) {
        model.addAttribute("videojuegos", videojuegoService.findAll());
        return "mostrar_videojuegos";
    }

    @GetMapping("/videojuegos/add")
    public String add(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        return "videojuego_add";
    }

    @PostMapping("/videojuegos/add")
    public String add(@ModelAttribute Videojuego videojuego, Model model) {
        videojuegoService.save(videojuego);
        return all(model);
    }

    @GetMapping("/videojuegos/delete")
    public String delete(@RequestParam(name = "id") Integer id, Model model) {
        videojuegoService.deleteById(id);
        return all(model);
    }

    @GetMapping("/videojuegos/edit")
    public String edit(@RequestParam(name = "id") Integer id, Model model) {
        Videojuego videojuego = videojuegoService.getById(id);
        model.addAttribute("videojuego", videojuego);
        return "videojuego_edit";
    }

    @PostMapping("/videojuegos/edit")
    public String edit(@ModelAttribute Videojuego videojuego, Model model) {
        videojuegoService.save(videojuego);
        return all(model);
    }
}
