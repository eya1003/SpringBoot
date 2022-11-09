package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Unievrsite;
import tn.esprit.spring.repositories.UniversiteRepository;

import java.util.Optional;
@Service
@Slf4j
public class UniversiteServiceImp implements IUniversiteService{

    @Autowired
    UniversiteRepository universiteRepository ;

    @Override
    public Long ajouter_Universite(Unievrsite e) {
        universiteRepository.save(e);
        log.info("Ajouter universite");
        return e.getIdUniv();
    }

    @Override
    public Unievrsite updateUniversite(Unievrsite e) {
        return universiteRepository.save(e);
    }

    @Override
    public Iterable<Unievrsite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public void deleteUniversite(long id) {
         universiteRepository.deleteById(id);
    }

    @Override
    public Optional<Unievrsite> findUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }
}
