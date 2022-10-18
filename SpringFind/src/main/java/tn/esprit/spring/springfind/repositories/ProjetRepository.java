package tn.esprit.spring.springfind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springfind.entities.Projet;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {
    List<Projet> findByEquipesIdEquipe(Long equipeId);
}
