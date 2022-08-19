package thomas.backendteknoland.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import thomas.backendteknoland.bo.Titre;
import thomas.backendteknoland.service.TitreService;

@Component
public class TitreConverter implements Converter<String, Titre> {

    @Autowired
    private TitreService titreService;

    @Override
    public Titre convert(String idAuFormatTexte) {
        long idTitre = Integer.parseInt(idAuFormatTexte);
        return titreService.getTitreById(idTitre);
    }
}

