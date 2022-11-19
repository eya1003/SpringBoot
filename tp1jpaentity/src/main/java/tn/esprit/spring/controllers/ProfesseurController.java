package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Professeur;
import tn.esprit.spring.services.IProfesseurService;

import java.util.Optional;

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

    @GetMapping("/findProfesseurById/{professeur-id}")
    @ResponseBody
    public Optional< Professeur > GetprofesseurbyId(@PathVariable("professeur-id") Long Id){
        return iProfesseurService.findProfesseurById(Id);
    }

    @GetMapping("/CalculSalaire/{prixHeure}/{id-prof}")
    @ResponseBody
    public float CalculSalaire(@PathVariable("prixHeure") float prixHeure,
                               @PathVariable("id-prof")long idProf)
    {

       return iProfesseurService.calculSalaire(prixHeure,idProf);
    }

    @GetMapping("/findNbHeurebyId/{professeur-id}")
    @ResponseBody
    public int GetnbHeurebyId(@PathVariable("professeur-id") Long Id){
        return iProfesseurService.getnbHeureById(Id);
    }



}
