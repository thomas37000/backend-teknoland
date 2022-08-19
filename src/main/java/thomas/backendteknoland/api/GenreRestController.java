package thomas.backendteknoland.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thomas.backendteknoland.bo.Genre;
import thomas.backendteknoland.service.GenreService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/genres")
public class GenreRestController {

    @Autowired
    GenreService genreService;

    @GetMapping
    public List<Genre> getListGenres() {
        return genreService.listeGenres();
    }

    @PostMapping
    public Genre postGenre(@RequestBody Genre genre) throws Exception {
        genreService.addGenre(genre);
        return genre;
    }

   /*
       @PutMapping("/{iGenre}")
        public Artiste putArtiste(@PathVariable Long idGenre, @RequestBody Genre genre) {
            if (idGenre != null) {
                genre.setId(idGenre);
                genreService.updateArtiste(genre);
            }
            return genre;
        }

        @DeleteMapping("/{idGenre}")
        public void deleteGenre(@PathVariable Long idGenre) {
            if (idGenre != null) {
                genreService.deleteGenreById(idGenre);
            }
        }
    */
}