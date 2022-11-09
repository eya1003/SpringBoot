package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.DetailEquipe;
import tn.esprit.spring.repositories.DetailEquipeRepository;


import java.util.Optional;


@Service
@Slf4j
public class DetailEquipeServiceImp implements IDetailEquipe {
    @Autowired
    DetailEquipeRepository detailEquipeRepository;

    public Long ajouterDetailEquipe(DetailEquipe d) {
        detailEquipeRepository.save(d);
        log.info("Ajouter DetailEquipe");
        return d.getIdDetailEquipe();
    }

    @Override
    public Iterable<DetailEquipe> retrieveAllDetailEquipe() {return detailEquipeRepository.findAll();}

    @Override
    public Optional< DetailEquipe > findDetailEquipeById(Long id) {
        return detailEquipeRepository.findById(id);
    }

    @Override
    public void deleteDetailEquipe(long id) {
        detailEquipeRepository.deleteById(id);}

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe d) {return detailEquipeRepository.save(d);}

}
