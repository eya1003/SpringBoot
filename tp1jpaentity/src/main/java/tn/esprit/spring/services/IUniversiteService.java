package tn.esprit.spring.services;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Universite;

import java.util.List;
import java.util.Set;

public interface IUniversiteService {
    public Iterable<Universite> retrieveAllUniversite();
    public void assignUniversiteToDepartement(Long idUniversite, Long
            idDepartement);
    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite);
    public Universite retrieveUniversite(Long idUniver);
}
