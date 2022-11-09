package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {
}
