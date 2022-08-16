package thomas.backendteknoland.bo;

import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Artiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtiste;
    @NonNull
    private String nom;
}
