package thomas.backendteknoland.service;

import thomas.backendteknoland.bo.Vinyle;

import java.util.List;

public interface VinyleService {

    void addVinyle(Vinyle vinyle) throws Exception;

    List<Vinyle> getVinyles();

    Vinyle getVinyleById(long id);

    void updateVinyle(Vinyle vinyle);

    void deleteVinyleById(Long id);
}
