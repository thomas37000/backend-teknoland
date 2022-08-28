package thomas.backendteknoland.service;

import thomas.backendteknoland.bo.Titre;

import java.util.List;

public interface TitreService {
    void addTitre(Titre titre) throws Exception;

    List<Titre> listeTitres();

    Titre getTitreById(long idTitre);

    Titre getTitreByNom(String nom);

    void updateTitre(Titre titre);

    void deleteTitreById(Long idTitre);
}
