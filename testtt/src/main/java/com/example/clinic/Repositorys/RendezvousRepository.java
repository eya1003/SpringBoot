package com.example.clinic.Repositorys;

import com.example.clinic.entity.RendezVous;
import com.example.clinic.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RendezvousRepository extends JpaRepository<RendezVous,Long> {
    public List<RendezVous> findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(Long id, Specialite sp);
    public List<RendezVous> findByDateRDVBetween(Date start, Date end);
}
