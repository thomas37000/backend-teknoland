package thomas.backendteknoland.bo;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGenre;
    @NonNull
    private String libelle;

    /**
     * On override equals pour pouvoir utiliser contains
     * Ici on dit qu'on considère que 2 genres sont égaux si ils ont leurs 2 libellés égaux
     */
    @Override
    public boolean equals(Object genre) {
        String libelle = ((Genre) genre).getLibelle();
        return this.libelle.equals(libelle);
    }

    /**
     * Constructeur utilisé pour initialiser les genres dans le service
     */
    public Genre(long idGenre, @NonNull String libelle) {
        this.idGenre = idGenre;
        this.libelle = libelle;
    }
}