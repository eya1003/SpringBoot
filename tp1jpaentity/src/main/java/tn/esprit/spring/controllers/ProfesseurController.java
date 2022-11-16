package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Professeur;
import tn.esprit.spring.services.IProfesseurService;

@RestController
@RequestMapping("/ProfesseurC")
public class ProfesseurController {
    @Autowired
    IProfesseurService iProfesseurService;

    @PostMapping("/addProfesseur")
    @ResponseBody
    public void addProfesseur(@RequestBody Professeur professeur){
        iProfesseurService.ajouter_professeur(professeur);
    }
    @GetMapping("/getAllProfesseur")
    @ResponseBody
    public  Iterable<Professeur> getAllProfesseur()
    {
        return iProfesseurService.getAllProfesseurs();
    }

    @PutMapping("/updateProfesseur")
    @ResponseBody
    public Professeur updateProfesseur(@RequestBody Professeur e){
        Professeur professeur= iProfesseurService.updateProfesseur(e);
        return  professeur;
    }

    @DeleteMapping("/deleteProfesseur/{Professeur-id}")
    @ResponseBody
    public  void removeProfesseur(@PathVariable("Professeur-id") Integer ProfesseurId){
        iProfesseurService.deleteProfesseur(ProfesseurId);
    }
}
