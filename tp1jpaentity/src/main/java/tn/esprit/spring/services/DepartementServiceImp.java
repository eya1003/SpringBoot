package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Professeur;
import tn.esprit.spring.repositories.DepartementRepository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

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
    public  Departement findDepartementById(Long id) {

        return departementRepository.findById(id).get();
    }

    @Override
    public void deleteDepartement(long id) {
        departementRepository.deleteById(id);}

    @Override
    public Departement updateDepartement(Departement d) {return departementRepository.save(d);}

    public Departement retrieveDepartement(Long idDep) {
        return departementRepository.findById(idDep).get();
    }

    public List<Etudiant> getEtudiantsByDepar (Long idDepartement){
        return  retrieveDepartement(idDepartement).getEtudiantList();
    }
    public List<Departement> search(String keyword) {
        if (keyword != null) {
            return departementRepository.search(keyword);
        }
        return departementRepository.findAll();
    }
}
