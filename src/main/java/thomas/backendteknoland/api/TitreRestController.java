package thomas.backendteknoland.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thomas.backendteknoland.bo.Titre;
import thomas.backendteknoland.service.TitreService;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/titres")
public class TitreRestController {
    @Autowired
    TitreService titreService;

    @GetMapping
    public List<Titre> getTitres() {
        return titreService.listeTitres();
    }

    @GetMapping("/{idTitre}")
    public Titre getTitreById(@PathVariable long idTitre) {
        return titreService.getTitreById(idTitre);
    }

    @PostMapping
    public Titre postTitre(@RequestBody Titre titre) throws Exception {
        titreService.addTitre(titre);
        return titre;
    }

    @PutMapping("/{idTitre}")
    public Titre putTitre(@PathVariable Long idTitre, @RequestBody Titre titre) {
        if (idTitre != null) {
            titre.setId(idTitre);
            titreService.updateTitre(titre);
        }
        return titre;
    }

    @DeleteMapping("/{idTitre}")
    public void deleteTitre(@PathVariable Long idTitre) {
        if (idTitre != null) {
            titreService.deleteTitreById(idTitre);
        }
    }
}
