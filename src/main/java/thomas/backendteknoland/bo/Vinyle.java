package thomas.backendteknoland.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Vinyle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVinyle;
    @NonNull
    private String titre;
    @NonNull
    private String format;
    @NonNull
    private String reference;
    // @URL
    private String image;
    private LocalDate dateDeSortie;

    // updated
    public void setId(Long id) {
    }
}
