package tn.esprit.spring.springfind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springfind.entities.Equipe;
import tn.esprit.spring.springfind.entities.Projet;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    @Query("SELECT equipe FROM Equipe equipe"
            + " INNER JOIN equipe.projets projet"
            + " INNER JOIN ProjetDetail detail"
            + " ON detail.idProjetDetail = projet.projetDetail.idProjetDetail"
            + " where detail.dateDebut > current_date"
            + " and detail.technologie =:technologie")
    List<Equipe> retrieveEquipesByProjetTechnologie(@Param("technologie")
                                                    String technologie);
}

