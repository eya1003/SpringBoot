package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repositories.DepartementRepository;
import tn.esprit.spring.repositories.UniversiteRepository;

import java.util.Optional;
@Service
@Slf4j
public class UniversiteServiceImp implements IUniversiteService{


    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;

    @Override
    public Long ajouter_Universite(Universite e) {
        universiteRepository.save(e);
        log.info("Ajouter universite");
        return e.getIdUniv();
    }

    @Override
    public Universite updateUniversite(Universite e) {
        return universiteRepository.save(e);
    }

    @Override
    public Iterable<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public void deleteUniversite(long id) {
         universiteRepository.deleteById(id);
    }

    @Override
    public Optional<Universite> findUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }


    public void assignUniversiteToDepartement(Long idU, Long idD){

            Universite universite = universiteRepository.findById(idU).orElse(null);
            Departement departement= departementRepository.findById(idD).orElse(null);

            universite.getDepartements().add(departement);
            universiteRepository.save(universite);
        }
    }

