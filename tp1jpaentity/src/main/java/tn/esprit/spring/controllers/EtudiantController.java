package tn.esprit.spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IEtudiantService;

import java.util.Optional;

@RestController
@RequestMapping("/EtudiantC")
@CrossOrigin(origins = "http://localhost:4200")
public class EtudiantController {
   @Autowired
    IEtudiantService etudiantService;

   @GetMapping("/")
    public String hello(){return "HEllo word3";}


    @PostMapping("/addEtudiant")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addEtudiant(@RequestBody Etudiant etudiant){
       etudiantService.ajouter_etudiant(etudiant);
    }

    @PutMapping("/updateEtudiant")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
       Etudiant etudiant= etudiantService.updateEtudiant(e);
       return  etudiant;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteEtudiant/{etudiant-id}")
    @ResponseBody
    public  void removeEtudiant(@PathVariable("etudiant-id") Integer etudiantId){
       etudiantService.deleteEtudiant(etudiantId);
    }
/*
    @GetMapping("/getOneEtudiant/{etudiantId}")
    public Iterable<Etudiant> getAllEtudiants(@PathVariable("etudiant-id") Integer etudiantId)
    {
        Iterable<Etudiant> etudiant= etudiantService.retrieveEtudiant(etudiantId);
        return  etudiant;
    }

*/

    @GetMapping("/findbyId/{etudiant-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Optional< Etudiant > GetEtudiantbyId(@PathVariable("etudiant-id") Long Id){
        return etudiantService.findEtudiantById(Id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAllEtuidant")
    @ResponseBody
    public  Iterable<Etudiant> getAllEtudiants()
    {
        return etudiantService.retrieveAllEtudiant();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/affecter-etudiat-departement/{etudiantid}/{departementid}")
    public void affecterEtudiantToDepartement(@PathVariable("etudiantid") Long etudiantId,
                                              @PathVariable("departementid") Long departementId)
    {
        etudiantService.assignEdtudiantToDepartement(etudiantId,departementId);
    }


    @PostMapping (value = "/affectationEtudiant_contrat_equipe/{contrat-id}/{equipe-id}")

    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Etudiant affectationEtudiantContratEquipe( @RequestBody Etudiant etudiant ,
                                                      @PathVariable("contrat-id") Long contratId ,
                                                      @PathVariable("equipe-id") Long equipeId )
    {
        Etudiant etudiant1 = etudiantService.AddAssignEtudiantToEquipeAndContrat(etudiant,contratId,equipeId );
        return etudiant1;
    }


}
