package tn.esprit.spring.services;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;

import java.util.Optional;

public interface IContratService {
    public Long ajouter_contrat(Contrat contrat);
    public Iterable<Contrat> retrieveAllContrat();
    public void deleteContrat(long id);
    Contrat updateContrat(Contrat c);
    Optional<Contrat> findContratById(Long id);
}
