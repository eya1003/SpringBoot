package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IContratService;

import java.util.Optional;

@RestController
@RequestMapping("/ContratC")
public class ContratController {
    @Autowired
    IContratService iContratService;

    @PostMapping("/addContrat")
    @ResponseBody
    public void addContrat(@RequestBody Contrat contrat){

        iContratService.ajouter_contrat(contrat);
    }


    @GetMapping("/getAllContrat")
    @ResponseBody
    public Iterable<Contrat> getAllContrat(){
     return iContratService.retrieveAllContrat();
     }

    @DeleteMapping("/daleteContrat/{id}")
    @ResponseBody
    public  void removeContrat(@PathVariable("id") Integer etudiantId){
        iContratService.deleteContrat(etudiantId);
    }

    @PutMapping("/updateContrat")
    @ResponseBody
    public Contrat updateContrat(@RequestBody Contrat e){
        Contrat contrat= iContratService.updateContrat(e);
        return  contrat;
    }

    @GetMapping("/findbyIdContrat/{id}")
    @ResponseBody
    public Optional< Contrat > GetContratbyId(@PathVariable("id") Long Id){
        return iContratService.findContratById(Id);
    }
}
