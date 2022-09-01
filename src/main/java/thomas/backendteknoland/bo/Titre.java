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
    private String nom;

    @Min(0)
    @Max(8) // 8 min
    private int duree;

    @ManyToOne
    //@JsonBackReference
    private Artiste artiste;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Vinyle vinyle;

    @Override
    public boolean equals(Object titre) {
        String nom = ((Titre) titre).getNom();
        return this.nom.equals(nom);
    }

    public Titre(long idTitre, @NonNull String nom, int duree) {
        this.idTitre = idTitre;
        this.nom = nom;
        this.duree = duree;
    }

    public void setId(Long idTitre) {
    }

}
