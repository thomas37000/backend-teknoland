package thomas.backendteknoland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import thomas.backendteknoland.bo.Vinyle;
import thomas.backendteknoland.service.GenreService;
import thomas.backendteknoland.service.VinyleService;

import javax.validation.Valid;

@Controller
public class VinyleController {

    /*
     * Comme on doit afficher dans le formulaire
     * - la liste des genres
     * - la liste des participants
     * Alors on est obligé d'injecter ParticipantService/GenreService en plus de FilmService
     */

    private GenreService genreService;

    @Autowired
    private VinyleService vinyleService;

    /*
     * J'affiche la liste des films sur une route à part
     */
    @GetMapping("/")
    private String getVinyles(String titre, Model model) {

        // Si jamais il y a un paramètre "titre" dans l'url, je filtre les films
        if (titre != null) {
            // model.addAttribute("listeFilms", vinyleService.getVinyleByTitre(titre));
            // pour plus de cohérence, je vais preremplir la barre de recherche avec le terme recherché
            model.addAttribute("recherche", titre);
        }
        // sinon, je retourne tous les films
        else {
            model.addAttribute("listeVinyles",  vinyleService.getVinyles());
        }
        return "vinyles";
    }

    /*
     * J'affiche le détail d'un film sur une route à part
     */
    @GetMapping("/vinyle-detail")
    private String getVinyleDetail(int id, Model model) {
        model.addAttribute("vinyle",  vinyleService.getVinyleById(id));
        return "vinyleDetail";
    }

    @GetMapping("/admin/ajout-vinyle")
    private String getVinyle(String titre, Model model) {
		/*if(titre != null) {
			model.addAttribute("film",vinyleService.getVinyleById(id));
			model.addAttribute("recherche", titre);
		}*/

        // afin que mon template remplisse un objet participant, je lui passe en attribut du modèle
        model.addAttribute("film", new Vinyle());

        // je passe également la liste des genres/participants pour pouvoir remplir les <select> dur formulaire
        majModeleAvecListes(model);
        return "ajout-vinyle";
    }

    @PostMapping("/admin/ajout-vinyle")
    private String postVinyle(@Valid Vinyle vinyle, BindingResult br, Model model) {

        // si on a des erreurs de validations, on retourne  le template pour les afficher
        if (br.hasErrors()) {
            majModeleAvecListes(model);
            return "ajout-vinyle";
        }

        // creer le participant via participantService
        try {
            vinyleService.addVinyle(vinyle);
        }
        // si jamais ca se passe mal
        catch (Exception e) {
            majModeleAvecListes(model);
            return "ajout-vinyle";
        }
        return "redirect:/";
    }

    // Supprimer un Vinyle
    @PostMapping("/vinyle-detail")
    private String deleteVinyle(long id) {
        vinyleService.deleteVinyleById(id);
        return "vinyles";
    }

    /**
     * Pour ne pas se répeter, je refactorise mes ajout de listes au modèle dans une méthod à part
     */
    private void majModeleAvecListes(Model model) {
        //model.addAttribute("listeParticipants", participantService.listeParticipants());
        model.addAttribute("listeGenres", genreService.listeGenres());
    }
}
