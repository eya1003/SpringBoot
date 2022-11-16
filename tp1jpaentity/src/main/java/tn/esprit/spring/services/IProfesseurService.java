package tn.esprit.spring.services;


import tn.esprit.spring.entity.Professeur;

public interface IProfesseurService {

    public Long ajouter_professeur(Professeur p );
    public Iterable<Professeur>  getAllProfesseurs() ;
    Professeur updateProfesseur(Professeur professeur);
    public void deleteProfesseur(long id);
}
