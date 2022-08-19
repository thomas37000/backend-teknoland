package thomas.backendteknoland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thomas.backendteknoland.bo.Titre;
import thomas.backendteknoland.service.TitreService;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/titres")
public class TitreController {

    @Autowired
    private TitreService titreService;


    @GetMapping
    private String getTitres(Model model) {
        model.addAttribute("newTitre", new Titre());
        model.addAttribute("listeTitre", titreService.getTitres());
        return "titres";
    }

    @PostMapping
    private String postTitre(@Valid Titre titre, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("listeTitre", titreService.getTitres());
            return "titres";
        }
        try {
            titreService.addTitre(titre);
        } catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("listeTitre", titreService.getTitres());
            return "titres";
        }
        return "redirect:/admin/titres";
    }
}
