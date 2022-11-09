package tn.esprit.spring.services;
import tn.esprit.spring.entity.Etudiant;

import java.util.Optional;

public interface IEtudiantService {
    public Long ajouter_etudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    public Iterable<Etudiant> retrieveAllEtudiant() ;
    public void deleteEtudiant(long id);
   // public Iterable<Etudiant> retrieveEtudiant(long id) ;

    Optional<Etudiant> findEtudiantById(Long id);
}
