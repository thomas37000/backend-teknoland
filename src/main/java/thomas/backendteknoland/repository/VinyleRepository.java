package thomas.backendteknoland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thomas.backendteknoland.bo.Artiste;
import thomas.backendteknoland.bo.Vinyle;

public interface VinyleRepository extends JpaRepository<Vinyle, Long> {
    Vinyle findByTitreVinyle(String titreVinyle);
}
