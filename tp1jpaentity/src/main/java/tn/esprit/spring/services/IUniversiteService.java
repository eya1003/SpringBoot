package tn.esprit.spring.services;

import tn.esprit.spring.entity.Unievrsite;

import java.util.Optional;

public interface IUniversiteService {
    public Long ajouter_Universite(Unievrsite e);
    Unievrsite updateUniversite(Unievrsite e);
    public Iterable<Unievrsite> retrieveAllUniversite() ;
    public void deleteUniversite(long id);

    Optional<Unievrsite> findUniversiteById(Long id);
}
