package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Contrat;

import java.util.Date;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
