package thomas.backendteknoland.repository;

import thomas.backendteknoland.bo.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

// String car l'id c'est le pseudo
public interface MembreRepository extends JpaRepository<Membre, String> {

}
