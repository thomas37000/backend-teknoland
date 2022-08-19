package thomas.backendteknoland.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thomas.backendteknoland.bo.Genre;
import thomas.backendteknoland.service.GenreService;

@Controller
@RequestMapping("/admin/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;


    @GetMapping
    private String getGenres(Model model) {
        model.addAttribute("newGenre", new Genre());
        model.addAttribute("listeGenre", genreService.listeGenres());
        return "genres";
    }

    @PostMapping
    private String postGenre(@Valid Genre genre, BindingResult br, Model model) {
        // si on a des erreurs de validations, on retourne  le template pour les afficher
        if (br.hasErrors()) {
            model.addAttribute("listeGenre", genreService.listeGenres());
            return "genres";
        }

        // creer le genre via genreService
        try {
            genreService.addGenre(genre);
        }
        // si jamais ca se passe mal
        catch (Exception e) {
            // on ajoute un attribut "erreur" au modèle
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("listeGenre", genreService.listeGenres());
            return "genres";
        }
        return "redirect:/admin/genres";
    }
}