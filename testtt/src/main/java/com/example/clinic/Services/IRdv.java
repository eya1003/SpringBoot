package com.example.clinic.Services;

import com.example.clinic.entity.RendezVous;
import com.example.clinic.entity.Specialite;

import java.util.Date;
import java.util.List;

public interface IRdv {
    void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long
            idPatient);

    List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    int getNbrRendezVousMedecin(Long idMedecin);

    void retrieveRendezVous();

    int getRevenuMedecin (Long idMedecin, Date startDate, Date endDate);
}
