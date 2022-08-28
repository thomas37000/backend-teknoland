package thomas.backendteknoland.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtiste;
    @NonNull
    private String pseudo;

    // un artiste peut avoir plusieurs titres sur un vinyle
    @OneToMany
    @JsonManagedReference
    private List<Titre> titresArtiste;

    // un artiste peut être sur plusieurs vinyles
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Vinyle vinyle;

    @Override
    public boolean equals(Object artiste) {
        String pseudo = ((Artiste) artiste).getPseudo();
        return this.pseudo.equals(pseudo);
    }

    public void setId(Long idArtiste) {
    }
}
