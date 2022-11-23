package tn.esprit.spring.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Departement;

import tn.esprit.spring.repositories.ContratRepository;
import tn.esprit.spring.repositories.DepartementRepository;
import tn.esprit.spring.repositories.EquipeRepository;
import tn.esprit.spring.repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Slf4j
@EnableScheduling
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository ;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Override
    public Long ajouter_etudiant(Etudiant e) {
        etudiantRepository.save(e);
        log.info("Ajouter etudiant");
        return e.getIdEtudiant();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {

        return etudiantRepository.save(e);
    }

    public Iterable<Etudiant> retrieveAllEtudiant() {

        return etudiantRepository.findAll();
    }

    public void deleteEtudiant(long id) {

        etudiantRepository.deleteById(id);
    }


 @Override
 public Optional< Etudiant > findEtudiantById(Long id) {
     return etudiantRepository.findById(id);
 }

    public void assignEdtudiantToDepartement( Long studiantId, Long departementId){
         Etudiant etudiant =etudiantRepository.findById(studiantId).orElse(null);
         Departement departement = departementRepository.findById(departementId).orElse(null);
         etudiant.setDepartement(departement);
         etudiantRepository.save(etudiant);
 }





    @Transactional
    public Etudiant AddAssignEtudiantToEquipeAndContrat( Etudiant e , Long idContrat , Long idequipe){

        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idequipe).orElse(null);
        contrat.setEtudiant(e);
        equipe.getEtudiantEquipe().add(e);
        return etudiantRepository.save(e);

    }


    @Scheduled(fixedRate = 60000)
    public void fixedRateMethod(){
        System.out.println("Method with fixed Rate");
    }




}
