package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entity.Professeur;

import java.util.List;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    @Query("SELECT p FROM Professeur p WHERE p.nomProf LIKE %?1%"
            + " OR p.prenomProf LIKE %?1%"
            + " OR p.emailProf LIKE %?1%"
            + " OR p.module LIKE %?1%"
          +  " OR p.classe LIKE %?1%"
            + " OR p.anneeAmb  LIKE %?1%"
            + " OR CONCAT(p.numTelProf, '') LIKE %?1%"
            + " OR CONCAT(p.nbrheure, '') LIKE %?1%"
          //  + " OR p.anneeAmb LIKE %:keyword%"

    )
    public List<Professeur> search(String keyword);
}
