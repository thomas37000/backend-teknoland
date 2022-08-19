package thomas.backendteknoland.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thomas.backendteknoland.bo.Artiste;

public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
}
