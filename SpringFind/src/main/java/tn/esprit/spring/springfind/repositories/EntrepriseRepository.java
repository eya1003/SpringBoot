package tn.esprit.spring.springfind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.springfind.entities.Entreprise;
import tn.esprit.spring.springfind.entities.Equipe;

import java.util.List;

public interface EntrepriseRepository  extends JpaRepository<Entreprise, Long> {
    @Query("SELECT entreprise FROM Entreprise entreprise , Equipe equipe where" +
            " entreprise.idEntreprise = equipe.entreprise.idEntreprise and equipe.specialite =:specialite")
    List<Entreprise> retrieveEntreprisesBySpecialiteEquipe(@Param("specialite")
            String specialite);

    @Modifying
    @Query("update Entreprise e set e.adresse = :adresse where e.idEntreprise = :idEntreprise")
            int updateEntrepriseByAdresse(@Param("adresse") String adresse,
            @Param("idEntreprise")
            Long idEntreprise);

    @Modifying
    @Query("DELETE FROM Entreprise e WHERE e.adresse= :adresse")
    int deleteFournisseurByCategorieFournisseur(@Param("adresse") String adresse);

}
