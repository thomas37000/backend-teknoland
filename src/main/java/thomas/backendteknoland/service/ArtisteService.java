package thomas.backendteknoland.service;

import thomas.backendteknoland.bo.Artiste;

import java.util.List;

public interface ArtisteService {

    void addArtiste(Artiste artiste) throws Exception;

    List<Artiste> ListeArtistes();

    Artiste getArtisteById(long id);
}
