package tn.esprit.spring.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Professeur;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

    @Query("SELECT p FROM Departement p WHERE p.nomDepart LIKE %?1%"
            + " OR CONCAT(p.nbEtage, '') LIKE %?1%"

    )
    public List<Departement> search(String keyword);

    Page<Departement> findDepartementBynomDepartContaining(String nomDepart, Pageable pageable);
}
