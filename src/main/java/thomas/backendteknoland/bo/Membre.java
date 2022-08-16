package thomas.backendteknoland.bo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Membre {

	@Id
	// pas de @GeneratedValue car l'id pseudo est autogénéré
	private String pseudo;
	private String password;
	private boolean admin;

    public Membre(String admin, String admin1, boolean b) {
    }

    /**
	 * On override equals pour pouvoir utiliser contains
	 * Ici on dit qu'on considère que 2 membres sont égaux si ils ont leurs 2 pseudos égaux 
	 */
	@Override
	public boolean equals(Object membre) {
		String pseudo = ((Membre) membre).getPseudo();
		return this.pseudo.equals(pseudo);
	}
}
