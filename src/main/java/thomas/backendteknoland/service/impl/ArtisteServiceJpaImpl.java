package thomas.backendteknoland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import thomas.backendteknoland.bo.Artiste;
import thomas.backendteknoland.repository.ArtisteRepository;
import thomas.backendteknoland.service.ArtisteService;

import java.util.List;

@Service
@Profile("prod")
public class ArtisteServiceJpaImpl implements ArtisteService {
    @Autowired
    private ArtisteRepository artisteRepository;

    public void addArtiste(Artiste artiste) throws Exception {
        artisteRepository.save(artiste);
    }

    @Override
    public List<Artiste> listeArtistes() {
        return artisteRepository.findAll();
    }

    @Override
    public Artiste getArtisteById(long idArtiste) {
        return artisteRepository.findById(idArtiste).get();
    }

    @Override
    public Artiste getArtisteByPseudo(String pseudo) {
        return artisteRepository.findByPseudo(pseudo);
    }

    @Override
    public void updateArtiste(Artiste artiste) {
        artisteRepository.save(artiste);
    }

    @Override
    public void deleteArtisteById(Long idArtiste) {
        artisteRepository.deleteById(idArtiste);
    }

}
