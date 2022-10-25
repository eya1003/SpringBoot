package tn.esprit.spring.springfind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springfind.entities.Projet;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {
    List<Projet> findByEquipesIdEquipe(Long equipeId);
    @Query("SELECT projet FROM Projet projet, ProjetDetail detail where "
            + "detail.idProjetDetail = projet.projetDetail.idProjetDetail "
            + "and detail.technologie =:technologie "
            + "and detail.cout_provisoire >:cout_provisoire")

    List<Projet> retrieveProjetsByCoutAndTechnologie(@Param("technologie") String technologie,
                                                     @Param("cout_provisoire") Long cout_provisoire);
}
