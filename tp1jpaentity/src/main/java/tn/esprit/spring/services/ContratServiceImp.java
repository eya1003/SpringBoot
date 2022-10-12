package tn.esprit.spring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

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
}
