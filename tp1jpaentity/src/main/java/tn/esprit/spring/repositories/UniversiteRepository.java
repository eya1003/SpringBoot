package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Unievrsite;

public interface UniversiteRepository extends JpaRepository<Unievrsite, Long> {
}
