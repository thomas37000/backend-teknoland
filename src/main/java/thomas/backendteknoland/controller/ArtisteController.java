package thomas.backendteknoland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thomas.backendteknoland.bo.Artiste;
import thomas.backendteknoland.service.ArtisteService;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/artistes")
public class ArtisteController {

    @Autowired
    private ArtisteService artisteService;

    @GetMapping
    private String getArtistes(Model model) {
        model.addAttribute("newArtiste", new Artiste());
        model.addAttribute("listeArtiste", artisteService.listeArtistes());
        return "artistes";
    }

    @PostMapping
    private String postArtiste(@Valid Artiste artiste, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("listeArtiste", artisteService.listeArtistes());
            return "artistes";
        }
        try {
            artisteService.addArtiste(artiste);
        }
        catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("listeArtiste", artisteService.listeArtistes());
            return "artistes";
        }
        return "redirect:/admin/artistes";
    }
}
