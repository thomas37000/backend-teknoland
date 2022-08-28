package thomas.backendteknoland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import thomas.backendteknoland.bo.Vinyle;
import thomas.backendteknoland.repository.VinyleRepository;
import thomas.backendteknoland.service.VinyleService;

import java.util.List;

@Service
@Profile("prod")
public class VinyleServiceJpaImp implements VinyleService {

    @Autowired
    private VinyleRepository vinyleRepository;

    @Override
    public void addVinyle(Vinyle vinyle) {
        vinyleRepository.save(vinyle);
    }

    @Override
    public List<Vinyle> getVinyles() {
        return vinyleRepository.findAll();
    }

    @Override
    public Vinyle getVinyleById(long idVinyle) {
        return vinyleRepository.findById(idVinyle).get();
    }

    @Override
    public Vinyle getVinyleByTitre(String titreVinyle) {
        return vinyleRepository.findByTitreVinyle(titreVinyle);
    }

    @Override
    public void updateVinyle(Vinyle vinyle) {
        vinyleRepository.save(vinyle);
    }

    @Override
    public void deleteVinyleById(Long idVinyle) {
        vinyleRepository.deleteById(idVinyle);
    }
}
