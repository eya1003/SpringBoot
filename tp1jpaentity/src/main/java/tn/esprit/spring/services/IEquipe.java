package tn.esprit.spring.services;

import tn.esprit.spring.entity.Equipe;

import java.util.Optional;

public interface IEquipe {
    public Long ajouter_Equipe(Equipe e);
    Equipe updateEquipe(Equipe e);
    public Iterable<Equipe> retrieveAllEquipe() ;
    public void deleteEquipe(long id);

    Optional<Equipe> findEquipeById(Long id);
}
