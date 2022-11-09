package tn.esprit.spring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

import java.util.Optional;

@Service
@Slf4j
public class ContratServiceImp implements  IContratService{

    @Autowired
    ContratRepository contratRepository ;
    @Override
    public Long ajouter_contrat(Contrat contrat) {
        contratRepository.save(contrat);
        log.info("Ajouter contrat");
        return contrat.getIdContrat();
    }

    public Iterable<Contrat> retrieveAllContrat() {

        return contratRepository.findAll();
    }

    public void deleteContrat(long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Optional<Contrat> findContratById(Long id) {
        return contratRepository.findById(id);
    }





}
