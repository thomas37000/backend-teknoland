package thomas.backendteknoland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import thomas.backendteknoland.bo.Titre;
import thomas.backendteknoland.repository.TitreRepository;
import thomas.backendteknoland.service.TitreService;

import java.util.List;

@Service
@Profile("prod")
public class TitreServiceJpaImpl implements TitreService {

    @Autowired
    private TitreRepository titreRepository;

    @Override
    public void addTitre(Titre titre) throws Exception {
        titreRepository.save(titre);
    }

    @Override
    public List<Titre> listeTitres() {
        return titreRepository.findAll();
    }

    @Override
    public Titre getTitreById(long idTitre) {
        // récupérer un titre by id de la Bdd
        return titreRepository.findById(idTitre).get();
    }

    @Override
    public Titre getTitreByNom(String nom) {
        return titreRepository.findByNom(nom);
    }

    @Override
    public void updateTitre(Titre titre) {
        titreRepository.save(titre);
    }

    @Override
    public void deleteTitreById(Long idTitre) {
        titreRepository.deleteById(idTitre);
    }

}
