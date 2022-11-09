package tn.esprit.spring.services;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;

import java.util.Optional;

public interface IDepartementService {

    public Long ajouterDepartement(Departement d);
    public Iterable<Departement> retrieveAllDepartement();
    Optional< Departement > findDepartementById(Long id);

    public void deleteDepartement(long id);
    Departement updateDepartement(Departement d);
}
