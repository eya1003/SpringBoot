package tn.esprit.spring.springfind.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springfind.entities.ProjetDetail;

import java.util.List;
@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail,Long> {
}
