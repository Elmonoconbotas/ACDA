package ACDA_UT4_1a1.controller;

import ACDA_UT4_1a1.model.entity.Capital;
import ACDA_UT4_1a1.model.entity.Pais;
import ACDA_UT4_1a1.model.service.CapitalService;
import ACDA_UT4_1a1.model.service.PaisService;
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

    @Autowired
    private CapitalService capitalService;

    @GetMapping("/paises")
    public String paises( Model model) {
        List<Pais> paises = paisService.findAll();
        model.addAttribute("paises", paises);
        return "paises";
    }

    @GetMapping("/pais")
    public String paisForm( Model model) {
        model.addAttribute("pais", new Pais());
        return "pais";
    }
    @PostMapping("/pais")
    public String paisSubmit(@ModelAttribute Pais pais, Model model) {
        System.out.println(pais);
        paisService.save(pais);
        model.addAttribute("pais", pais);

        return paises(model);
    }


    @GetMapping("/pais/editar")
    public String getEditarPais( Model model) {
        model.addAttribute("pais", new Pais());
        return "editarPais";
    }
    @PostMapping("/pais/editar")
    public String editarPais(@ModelAttribute Pais pais, Model model) {
        System.out.println(pais);
        pais.setCapital(capitalService.getByID(pais.getCapital().getId()));
        paisService.save(pais);
        model.addAttribute("pais", pais);

        return paises(model);
    }

    @GetMapping("/paises/delete")
    public String delete(@ModelAttribute Pais pais, Model model) {
        paisService.deleteById(pais.getId());

        return paises(model);
    }
}
