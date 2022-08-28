/////////////////////// VINYLE //////////////////////////////////////////////////

package thomas.backendteknoland.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Past;
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
    @URL
    private String image;
    @Past
    private LocalDate dateDeSortie;

    // un vinyle peut avoir plusieurs genres
    // et plusieurs vinyles peuvent avoir le même genre
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable( name="vinyle_genres",
            joinColumns = { @JoinColumn(name = "idVinyle") },
            inverseJoinColumns = { @JoinColumn(name = "idGenre") })
    @JsonManagedReference
    private List<Genre> genre;

    // un vinyle peut avoir plusieurs artistes
    @OneToMany
    @JoinTable( name="vinyle_artistes",
            joinColumns = { @JoinColumn(name = "idVinyle") },
            inverseJoinColumns = { @JoinColumn(name = "idArtiste") })
    @JsonManagedReference
    private List<Artiste> artiste;

    // un vinyle peut avoir plusieurs titres
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable( name="vinyle_titres",
            joinColumns = { @JoinColumn(name = "idVinyle") },
            inverseJoinColumns = { @JoinColumn(name = "idTitre") })
    @JsonManagedReference
    private List<Titre> titre;

    // updated
    public void setId(Long idVinyle) {
    }

    public Vinyle(
            long idVinyle,
            @NonNull String titreVinyle,
            @NonNull String format,
            @NonNull String reference,
            String image,
            LocalDate dateDeSortie,
            List<Genre> genreList,
            List<Artiste> artisteList,
            List<Titre> titreList) {
        this.idVinyle = idVinyle;
        this.titreVinyle = titreVinyle;
        this.format = format;
        this.reference = reference;
        this.image = image;
        this.dateDeSortie = dateDeSortie;
    }
}