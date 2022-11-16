package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
}
