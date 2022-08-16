package thomas.backendteknoland.service;

import thomas.backendteknoland.bo.Membre;

import java.util.List;


public interface MembreService {

    /**
     * 1. On va avoir besoin de créer des membres
     */
    public void addMembre(Membre membre) throws Exception;

    /**
     * 2. On va avoir besoind de lister les membres	 *
     */
    public List<Membre> listeMembres();

    /**
     * 3. On va avoir besoin de recupérer un membre à partir de son pseudo
     */
    public Membre getMembreByPseudo(String pseudo);
}
