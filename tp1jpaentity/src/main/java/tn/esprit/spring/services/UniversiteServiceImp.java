package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repositories.DepartementRepository;
import tn.esprit.spring.repositories.UniversiteRepository;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@EnableScheduling
@Slf4j
public class UniversiteServiceImp implements IUniversiteService{

    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public Iterable<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    public void assignUniversiteToDepartement(Long idUniversite, Long
            idDepartement){

        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement= departementRepository.findById(idDepartement).orElse(null);

        universite.getDepartements().add(departement);
        universiteRepository.save(universite);


    }


    public Universite retrieveUniversite(Long idUniver){
        return  universiteRepository.findById(idUniver).get();
    }
    //récupérer départements d’une université donnée
    public Set<Departement> retrieveDepartementsByUniversite(Long idUniversite){
        return  retrieveUniversite(idUniversite).getDepartements();
    }
}
