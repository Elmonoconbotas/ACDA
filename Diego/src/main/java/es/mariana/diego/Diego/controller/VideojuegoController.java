package es.mariana.diego.Diego.controller;

import es.mariana.diego.Diego.model.dao.IVideojuegoDAO;
import es.mariana.diego.Diego.model.entity.Videojuego;
import es.mariana.diego.Diego.model.service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping("/videojuegos")
    public String greetingForm(Model model) {
        //model.getAttribute("apellidos");
        model.addAttribute("videojuego", new Videojuego());
        return "videojuegos";
    }

    @PostMapping("/videojuegos")
    public String greetingSubmit(@ModelAttribute Videojuego videojuego, Model model) {
        videojuegoService.save(videojuego);
        model.addAttribute("videojuego", videojuego);
        return "videojuegos";
    }

    @GetMapping("/videojuegos/delete")
    public String delete(@ModelAttribute Videojuego videojuego, Model model) {
        videojuegoService.delete(videojuego.getId());
        return all(model);
    }
    @GetMapping("/videojuegos/edit")
    public String edit(@RequestParam(name = "id")Integer id,  Model model) {
        Videojuego videojuego = videojuegoService.getById(id);
        model.addAttribute("videojuego", videojuego);
        return "videojuegos_edit";
    }
    @PostMapping("/videojuegos/edit")
    public String edit(@ModelAttribute Videojuego videojuego, Model model) {
        videojuegoService.save(videojuego);
        model.addAttribute("videojuego", videojuego);
        return "catalogo";
    }

    @GetMapping("/videojuegos/all")
    public String all(Model model){
        List<Videojuego> videojuegos = videojuegoService.findAll();
        model.addAttribute("videojuegos", videojuegos);
        return "catalogo";
    }
}
