package thomas.backendteknoland.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.URL;

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

    private String logo;

    @Override
    public boolean equals(Object artiste) {
        String pseudo = ((Artiste) artiste).getPseudo();
        return this.pseudo.equals(pseudo);
    }

    public Artiste(long idArtiste, @NonNull String pseudo, String logo) {
        this.idArtiste = idArtiste;
        this.pseudo = pseudo;
        this.logo = logo;
    }

    public void setId(Long idArtiste) {
    }
}
