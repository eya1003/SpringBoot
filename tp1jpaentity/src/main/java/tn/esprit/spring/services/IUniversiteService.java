package tn.esprit.spring.services;

import tn.esprit.spring.entity.Universite;

import java.util.Optional;

public interface IUniversiteService {
    public Long ajouter_Universite(Universite e);
    Universite updateUniversite(Universite e);
    public Iterable<Universite> retrieveAllUniversite() ;
    public void deleteUniversite(long id);

    Optional<Universite> findUniversiteById(Long id);
    public void assignUniversiteToDepartement(Long idUniversite, Long
            idDepartement);
}
