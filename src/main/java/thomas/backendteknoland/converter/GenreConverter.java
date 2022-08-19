package thomas.backendteknoland.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import thomas.backendteknoland.bo.Genre;
import thomas.backendteknoland.service.GenreService;

@Component
public class GenreConverter implements Converter<String, Genre> {

    @Autowired
    private GenreService genreService;

    @Override
    public Genre convert(String idAuFormatTexte) {
        long idGenre = Integer.parseInt(idAuFormatTexte);
        return genreService.getGenreById(idGenre);
    }
}

