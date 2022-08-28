package thomas.backendteknoland.service;

import thomas.backendteknoland.bo.Genre;

import java.util.List;

public interface GenreService {

    void addGenre(Genre genre) throws Exception;

    List<Genre> listeGenres();

    Genre getGenreById(long idGenre);

    void deleteGenreById(Long id);
}
