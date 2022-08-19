package thomas.backendteknoland.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
public class Titre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTitre;

    @NonNull
    private String libelle;

    @Min(0)
    @Max(8) // 8 min
    private int duree;

    @Override
    public boolean equals(Object titre) {
        String libelle = ((Titre) titre).getLibelle();
        return this.libelle.equals(libelle);
    }

    public Titre(String libelle) {
        this.libelle = libelle;
    }

    public void setId(Long idTitre) {
    }

    @ManyToOne // 0..* => 1
    private Artiste artiste;

    // plusieurs titres d'un artiste pour un vinyle
    @ManyToOne // 0..* => 1
    @JsonBackReference
    private Vinyle vinyle;

     //@OneToOne(mappedBy = "titre")


}
