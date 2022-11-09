package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.repositories.DepartementRepository;


import java.util.Optional;

@Service
@Slf4j
public class DepartementServiceImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;

    public Long ajouterDepartement(Departement d) {
        departementRepository.save(d);
        log.info("Ajouter Departement");
        return d.getIdDepart();
    }

    @Override
    public Iterable<Departement> retrieveAllDepartement() {return departementRepository.findAll();}

    @Override
    public Optional< Departement > findDepartementById(Long id) {
        return departementRepository.findById(id);
    }

    @Override
    public void deleteDepartement(long id) {
        departementRepository.deleteById(id);}

    @Override
    public Departement updateDepartement(Departement d) {return departementRepository.save(d);}

}
