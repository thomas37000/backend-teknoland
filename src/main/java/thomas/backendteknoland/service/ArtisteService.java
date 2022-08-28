package thomas.backendteknoland.service;

import thomas.backendteknoland.bo.Artiste;

import java.util.List;

public interface ArtisteService {

    void addArtiste(Artiste artiste) throws Exception;

    List<Artiste> listeArtistes();

    Artiste getArtisteByPseudo(String pseudo);

    Artiste getArtisteById(long id);

    void updateArtiste(Artiste artiste);

    void deleteArtisteById(Long idArtiste);
}
