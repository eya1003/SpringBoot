package tn.esprit.spring.services;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Etudiant;

public interface IEtudiantService {
    public Long ajouter_etudiant(Etudiant e);
}
