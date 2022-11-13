package tn.esprit.spring.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

import java.util.Optional;

@Service
@Slf4j
public class ContratServiceImp implements  IContratService{

    @Autowired
    ContratRepository contratRepository ;
    @Autowired
    EtudiantRepository etudiantRepository ;
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
/*
    public vois Contrat affectContratToEtudiant(Contrat ce, String nomE,String prenomE){
        Etudiant etudiant =etudiantRepository.findAll(nomE,prenomE).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }
*/
@Override
public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
    Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
    if (etudiant != null) {
        int nombreContratActif = 0;
        for (Contrat contrat : etudiant.getContrat()) {
            if (contrat.getArchive() == true)
                nombreContratActif++;
        }
        if (nombreContratActif < 5) {
            ce.setEtudiant(etudiant);
            ce.setArchive(true);
            updateContrat(ce);
        }
    }
    return ce;
}


}
