package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Contrat;
@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
