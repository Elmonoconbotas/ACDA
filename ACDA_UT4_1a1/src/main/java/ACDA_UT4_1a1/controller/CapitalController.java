package ACDA_UT4_1a1.controller;

import ACDA_UT4_1a1.model.entity.Capital;
import ACDA_UT4_1a1.model.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CapitalController {
    @Autowired
    private CapitalService capitalService;

    @GetMapping("/capitales")
    public String capitales( Model model) {
        List<Capital> capitales = capitalService.findAll();
        model.addAttribute("capitales", capitales);
        return "capitales";
    }

    @GetMapping("/capital")
    public String capitalForm( Model model) {
        model.addAttribute("capital", new Capital());
        return "capital";
    }
    @PostMapping("/capital")
    public String capitalSubmit(@ModelAttribute Capital capital, Model model) {

        capitalService.save(capital);
        model.addAttribute("capital", capital);

        return capitales(model);
    }

    @GetMapping("/capital/editar")
    public String getEditarCapital(Model model) {
        model.addAttribute("capital", new Capital());
        return "editarCapital";
    }
    @PostMapping("/capital/editar")
    public String editarCapital(@ModelAttribute Capital capital, Model model) {
        capitalService.update(capital);
        model.addAttribute("capital", capital);

        return capitales(model);
    }

    @GetMapping("/capitales/delete")
    public String delete(@ModelAttribute Capital capital,Model model) {
        capitalService.deleteById(capital.getId());

        return capitales(model);
    }


}
