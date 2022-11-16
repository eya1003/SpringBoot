package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Professeur;
import tn.esprit.spring.repositories.ProfesseurRepository;

@Service
@Slf4j
public class ProfesseurServiceImp implements IProfesseurService{

  @Autowired
    ProfesseurRepository professeurRepository;

    @Override
    public Long ajouter_professeur(Professeur p) {
        professeurRepository.save(p);
        log.info("Ajouter Professeur");
      return p.getIdProfesseur();
    }

    @Override
    public Iterable<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    @Override
    public Professeur updateProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    @Override
    public void deleteProfesseur(long id) {
         professeurRepository.deleteById(id);
    }
}
