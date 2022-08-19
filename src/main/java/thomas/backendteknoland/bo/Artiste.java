package thomas.backendteknoland.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Artiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtiste;
    @NonNull
    private String nom;

    // private boolean unTitre;
    // private boolean plusieursTitres;

    public void setId(Long idArtiste) {
    }
}
