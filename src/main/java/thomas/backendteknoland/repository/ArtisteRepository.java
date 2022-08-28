package thomas.backendteknoland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thomas.backendteknoland.bo.Artiste;

public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
    Artiste findByPseudo(String pseudo); // pour une méthode de recherche avec un input
}
