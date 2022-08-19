package thomas.backendteknoland.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thomas.backendteknoland.bo.Artiste;
import thomas.backendteknoland.bo.Titre;
import thomas.backendteknoland.service.ArtisteService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/artistes")
public class ArtisteRestController {
    @Autowired
    ArtisteService artisteService;

    @GetMapping
    public List<Artiste> getListArtistes() {
        return artisteService.listeArtistes();
    }

    @GetMapping("/{idArtiste}")
    public Artiste getArtisteById(@PathVariable long idArtiste) {
        return artisteService.getArtisteById(idArtiste);
    }

    @PostMapping
    public Artiste postArtiste(@RequestBody Artiste artiste) throws Exception {
        artisteService.addArtiste(artiste);
        return artiste;
    }

    @PutMapping("/{idTitre}")
    public Artiste putArtiste(@PathVariable Long idArtiste, @RequestBody Artiste artiste) {
        if (idArtiste != null) {
            artiste.setId(idArtiste);
            artisteService.updateArtiste(artiste);
        }
        return artiste;
    }

    @DeleteMapping("/{idArtiste}")
    public void deleteArtiste(@PathVariable Long idArtiste) {
        if (idArtiste != null) {
            artisteService.deleteArtisteById(idArtiste);
        }
    }
}