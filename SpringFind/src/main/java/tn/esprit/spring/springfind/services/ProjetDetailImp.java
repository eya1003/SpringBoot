package tn.esprit.spring.springfind.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.springfind.entities.ProjetDetail;
import tn.esprit.spring.springfind.repositories.ProjetDetailRepository;
import tn.esprit.spring.springfind.repositories.ProjetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetDetailImp {

@Autowired
    ProjetDetailRepository DetailRepository;

    public ProjetDetail ajout(ProjetDetail dtail) {
        return  DetailRepository.save(dtail);
    }


    public List<ProjetDetail> getall(){
        return DetailRepository.findAll();
    }

    public Optional<ProjetDetail> getone(Long id) {
        return DetailRepository.findById(id);
    }
/*
    public void delete( Long id) {
        repository.deleteById(id);
    }

    public DetailEquipe replace( DetailEquipe c,  Long id) {
        return repository.findById(id)
                .map(dtail -> {
                    dtail.setSalle(c.getSalle());
                    dtail.setThematique(c.getThematique());


                    return repository.save(dtail);
                })
                .orElseGet(() -> {
                    c.setIdDetailEquipe(id);
                    return repository.save(c);
                });
    }
    */
}
