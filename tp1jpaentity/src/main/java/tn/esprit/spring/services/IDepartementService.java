package tn.esprit.spring.services;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IDepartementService {

    public Long ajouterDepartement(Departement d);
    public Iterable<Departement> retrieveAllDepartement();
    Departement  findDepartementById(Long id);

    public void deleteDepartement(long id);
    Departement updateDepartement(Departement d);
    public Departement retrieveDepartement(Long idDep);
    public List<Etudiant> getEtudiantsByDepar (Long idDepartement);
}
