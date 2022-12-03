package com.example.clinic.Services;

import com.example.clinic.Repositorys.MedecinRepository;
import com.example.clinic.Repositorys.PaitenRepository;
import com.example.clinic.Repositorys.RendezvousRepository;
import com.example.clinic.entity.RendezVous;
import com.example.clinic.entity.Specialite;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RdvService implements IRdv {

    private RendezvousRepository rendezvousRepository;
    private MedecinRepository medecinRepository;
    private PaitenRepository paitenRepository;


    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient){
        if(!medecinRepository.findById(idMedecin).isPresent()){
           log.error("medicin not found");
        }
        if(!paitenRepository.findById(idPatient).isPresent()){
            log.error("paitient not found");
        }
        rdv.setPatient(paitenRepository.findById(idPatient).get());
        rdv.setMedecin(medecinRepository.findById(idMedecin).get());
        rendezvousRepository.save(rdv);
    }
    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite){

        return rendezvousRepository.findByMedecinCliniquesIdCliniqueAndMedecinSpecialite(idClinique,specialite);
    }
    @Override
    public int getNbrRendezVousMedecin(Long idMedecin){
        return medecinRepository.findById(idMedecin).get().getRendezVous().size();
    }

    @Override
    public void retrieveRendezVous(){
        for (RendezVous element:rendezvousRepository.findAll()) {
            Long dif = element.getDateRDV().getTime()- new Date().getTime();
            System.out.println("db date: "+element.getDateRDV().getTime());
            System.out.println("sys date: "+new Date().getTime());
            System.out.println(dif);
            if (dif>0){
                log.info("La Liste des RendVous: "+element.getDateRDV()+ " : Medicine : "+element.getMedecin().getNomMedecin()+ " : Patient : "+element.getPatient().getNomPatient());
            }
        }
    }
    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate){
            //medecinRepository.findById(idMedecin);
        int prix=0;
            rendezvousRepository.findByDateRDVBetween(startDate,endDate);
        for (RendezVous element:rendezvousRepository.findByDateRDVBetween(startDate,endDate)) {

            System.out.println(element.getDateRDV());
           if (element.getMedecin().getIdMedecin() == idMedecin){
               System.out.println(medecinRepository.findById(idMedecin).get().getPrixConsultation());
               System.out.println( medecinRepository.findById(idMedecin).get().getRendezVous().size());
              prix = medecinRepository.findById(idMedecin).get().getPrixConsultation() * medecinRepository.findById(idMedecin).get().getRendezVous().size();
              break;
           }
        }
        return prix;

    }
}
