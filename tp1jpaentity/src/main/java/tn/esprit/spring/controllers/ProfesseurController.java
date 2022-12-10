package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Professeur;
import tn.esprit.spring.services.IProfesseurService;

import java.util.List;
import java.util.Optional;

@RestController
@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ProfesseurC")
public class ProfesseurController {
    @Autowired
    IProfesseurService iProfesseurService;

    @PostMapping("/addProfesseur")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addProfesseur(@RequestBody Professeur professeur){
        iProfesseurService.ajouter_professeur(professeur);
    }
    @GetMapping("/getAllProfesseur")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public  Iterable<Professeur> getAllProfesseur()
    {

        return iProfesseurService.getAllProfesseurs();
    }

    @PutMapping("/updateProfesseur")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Professeur updateProfesseur(@RequestBody Professeur e){
        Professeur professeur= iProfesseurService.updateProfesseur(e);
        return  professeur;
    }

    @DeleteMapping("/deleteProfesseur/{Professeur-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public  void removeProfesseur(@PathVariable("Professeur-id") Integer ProfesseurId){
        iProfesseurService.deleteProfesseur(ProfesseurId);
    }

    @GetMapping("/findProfesseurById/{professeur-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Optional< Professeur > GetprofesseurbyId(@PathVariable("professeur-id") Long Id){
        return iProfesseurService.findProfesseurById(Id);
    }

    @GetMapping("/CalculSalaire/{prixHeure}/{id-prof}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public float CalculSalaire(@PathVariable("prixHeure") float prixHeure,
                               @PathVariable("id-prof")long idProf)
    {

       return iProfesseurService.calculSalaire(prixHeure,idProf);
    }

    @GetMapping("/findNbHeurebyId/{professeur-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public int GetnbHeurebyId(@PathVariable("professeur-id") Long Id){
        return iProfesseurService.getnbHeureById(Id);
    }



    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Professeur> viewHomePage(String keyword) {
        List<Professeur> professeurs= iProfesseurService.search(keyword);
        return professeurs;
    }

    @PostMapping(value = "/add-professeur-departement/{departementid}")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public Professeur affecterprofesseurToDepartement(@RequestBody Professeur Par,@PathVariable("departementid") Long departementId)
    {

        Professeur prof1 = iProfesseurService.addProfesseurandAffectDepartement(Par,departementId);
        return prof1;
    }

    @PutMapping(value = "/affecter-professeur-departement/{profid}/{departementid}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void affecterprofesseurToDepartement(@PathVariable("profid") Long profid,
                                                      @PathVariable("departementid") Long departementId)
    {

        iProfesseurService.assignProfesseurToDepartement(profid,departementId);

    }

    @GetMapping("/searchProf/{p}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Professeur> rechercheProfesseur ( @PathVariable("p") String keyword) {
        Iterable<Professeur> listProfesseur = iProfesseurService.search(keyword);
        return listProfesseur;
    }
}
