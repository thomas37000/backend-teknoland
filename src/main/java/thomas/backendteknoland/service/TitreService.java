package thomas.backendteknoland.service;

import thomas.backendteknoland.bo.Titre;

import java.util.List;

public interface TitreService {
    void addTitre(Titre titre) throws Exception;

    List<Titre> getTitres();

    Titre getTitreById(long idTitre);

    void updateTitre(Titre titre);

    void deleteTitreById(Long idTitre);
}
