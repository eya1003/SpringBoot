package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.repositories.EquipeRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class EquipeServiceImp implements IEquipe{

    EquipeRepository equipeRepository ;

    @Override
    public Long ajouter_Equipe(Equipe e) {
        equipeRepository.save(e);
        log.info("Ajouter equipe");
        return e.getIdEquipe();
    }

    @Override
    public Equipe updateEquipe(Equipe e) {

        return equipeRepository.save(e);
    }

    @Override
    public Iterable<Equipe> retrieveAllEquipe() {

        return equipeRepository.findAll();
    }

    @Override
    public void deleteEquipe(long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Optional<Equipe> findEquipeById(Long id) {

        return equipeRepository.findById(id);
    }
}
