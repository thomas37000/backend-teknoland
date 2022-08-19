package thomas.backendteknoland.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import thomas.backendteknoland.bo.Artiste;
import thomas.backendteknoland.service.ArtisteService;


@Component
public class ArtisteConverter implements Converter<String, Artiste> {
    @Autowired
    private ArtisteService artisteService;

    @Override
    public Artiste convert(String idAuFormatTexte) {
        long idArtiste = Integer.parseInt(idAuFormatTexte);
        return artisteService.getArtisteById(idArtiste);
    }
}



