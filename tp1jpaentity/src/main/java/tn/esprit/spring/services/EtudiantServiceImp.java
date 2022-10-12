package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.EtudiantRepository;

@Service
@Slf4j
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository ;

    @Override
    public Long ajouter_etudiant(Etudiant e) {
        etudiantRepository.save(e);
        log.info("Ajouter etudiant");
        return e.getIdEtudiant();
    }
}
