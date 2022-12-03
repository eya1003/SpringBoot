package com.example.clinic.Controllers;

import com.example.clinic.Services.IRdv;
import com.example.clinic.entity.RendezVous;
import com.example.clinic.entity.Specialite;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
public class RdvController {
    private IRdv RDV;

    @PostMapping("/addrdv/{idmed}/{idpa}")
    public ResponseEntity<?> ShowAllUsers(@RequestBody RendezVous rdv, @PathVariable("idmed") Long idmed,@PathVariable("idpa") Long idpa ){
        RDV.addRDVAndAssignMedAndPatient(rdv,idmed,idpa);
        return new ResponseEntity<>("Done" , HttpStatus.OK);
    }
    @GetMapping("/getrdv/{idclinique}/{sp}")
    public ResponseEntity<?> getrdv(@PathVariable("idclinique") Long idclinique,@PathVariable("sp") Specialite sp ){
        RDV.getRendezVousByCliniqueAndSpecialite(idclinique, sp);
        return new ResponseEntity<>(RDV.getRendezVousByCliniqueAndSpecialite(idclinique, sp) , HttpStatus.OK);
    }
    @GetMapping("/getrdvmed/{idclinique}")
    public ResponseEntity<?> getrdv(@PathVariable("idclinique") Long idclinique ){
        RDV.getNbrRendezVousMedecin(idclinique);
        return new ResponseEntity<>(RDV.getNbrRendezVousMedecin(idclinique) , HttpStatus.OK);
    }

    @Scheduled(fixedRate = 30000)
    public ResponseEntity<?> getrdv( ){
        RDV.retrieveRendezVous();
        return new ResponseEntity<>("tt", HttpStatus.OK);
    }
    @GetMapping("/get/{idMedecin}/{startDate}/{endDate}")
    public ResponseEntity<?> get(@PathVariable("idMedecin") Long idMedecin,
                                 @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                 @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate){
        RDV.getRevenuMedecin(idMedecin, startDate, endDate);
        return new ResponseEntity<>(RDV.getRevenuMedecin(idMedecin, startDate, endDate) , HttpStatus.OK);
    }
}
