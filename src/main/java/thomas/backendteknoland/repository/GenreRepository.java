package thomas.backendteknoland.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import thomas.backendteknoland.bo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    // méthode qui renvoie un genre à partir du libellé
    Genre findByLibelle(String libelle);

    // méthode qui renvoie true si un genre avec ce libellé existe, false sinon
    boolean existsByLibelle(String libelle);

}
