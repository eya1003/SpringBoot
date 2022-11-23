package tn.esprit.spring.services;


import tn.esprit.spring.entity.Professeur;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProfesseurService {

    public Long ajouter_professeur(Professeur p );
    public Iterable<Professeur>  getAllProfesseurs() ;
    Professeur updateProfesseur(Professeur professeur);
    public void deleteProfesseur(long id);
    public Optional<Professeur> findProfesseurById(Long id);

    public float calculSalaire(float prixHeure, Long id);
    public int getnbHeureById(Long id);
   // public LocalDate getCurrentTimeUsingCalendar();
  //  public float CalculSalaireWithDate(float prixHeure, Long id);

    public List<Professeur> search(String rech);
}
