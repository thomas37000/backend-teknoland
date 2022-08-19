package thomas.backendteknoland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import thomas.backendteknoland.bo.Genre;
import thomas.backendteknoland.repository.GenreRepository;
import thomas.backendteknoland.service.GenreService;

import java.util.List;


@Service
@Profile("prod")
public class GenreServiceJpaImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void addGenre(Genre genre) throws Exception {
        // ajouter un genre à la Bdd
        genreRepository.save(genre);
    }

    @Override
    public List<Genre> listeGenres() {
        // récupérer tous les genres de la Bdd
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(long idGenre) {
        // récupérer un genre by id de la Bdd
        return genreRepository.findById(idGenre).get();
    }

}