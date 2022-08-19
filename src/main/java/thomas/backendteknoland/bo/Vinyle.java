package thomas.backendteknoland.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Vinyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVinyle;
    @NonNull
    private String titreVinyle;
    @NonNull
    private String format;
    @NonNull
    private String reference;
    // @URL
    private String image;
    private LocalDate dateDeSortie;

    // updated
    public void setId(Long idVinyle) {
    }

    @ManyToOne // 0..* => 1
    private Genre genre;


    // @ManyToOne
    //   private Artiste unTitre;
    // @ManyToMany
    // private List<Artiste> artiste;

    // 1 => 0..*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "titre_id")
    @JsonManagedReference
    private List<Titre> titre;


}
