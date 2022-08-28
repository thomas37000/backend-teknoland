package thomas.backendteknoland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thomas.backendteknoland.bo.Genre;
import thomas.backendteknoland.bo.Titre;

public interface TitreRepository extends JpaRepository<Titre, Long> {
    Titre findByNom(String titre);
}