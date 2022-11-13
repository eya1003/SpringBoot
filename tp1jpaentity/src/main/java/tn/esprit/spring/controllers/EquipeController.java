package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.services.IEquipe;

import java.util.Optional;

@RestController
@RequestMapping("/EquipeC")
public class EquipeController {

    @Autowired
    IEquipe equipeInterface;

    @PostMapping("/addEquipe")
    @ResponseBody
    public void addEquipe(@RequestBody Equipe equipe){
        equipeInterface.ajouter_Equipe(equipe);
    }

    @PutMapping("/updateEquipe")
    @ResponseBody
    public Equipe updateEquipe(@RequestBody Equipe e){
        Equipe eq= equipeInterface.updateEquipe(e);
        return  eq;
    }

    @DeleteMapping("/daleteEquipe/{id}")
    @ResponseBody
    public  void removeEquipe(@PathVariable("id") Long eqId){

        equipeInterface.deleteEquipe(eqId);
    }


    @GetMapping("/getAllEquipe")
    @ResponseBody
    public Iterable<Equipe> getAllEquipe(){

        return equipeInterface.retrieveAllEquipe();
    }

    @GetMapping("/findbyIdEquipe/{id}")
    @ResponseBody
    public Optional< Equipe > GetEquipebyId(@PathVariable("id") Long Id){
        return equipeInterface.findEquipeById(Id);
    }


}
