package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entity.Unievrsite;
import tn.esprit.spring.services.IUniversiteService;

import java.util.Optional;

@RestController
@RequestMapping("/UniversiteC")
public class UniversiteController {

    @Autowired
    IUniversiteService iUniversiteService;

    @PostMapping("/addUniversite")
    @ResponseBody
    public void addUniversite(@RequestBody Unievrsite univ){
        iUniversiteService.ajouter_Universite(univ);
    }

    @PutMapping("/updateUniversite")
    @ResponseBody
    public Unievrsite updateUniversite(@RequestBody Unievrsite e){
        Unievrsite eq= iUniversiteService.updateUniversite(e);
        return  eq;
    }

    @DeleteMapping("/daleteUniversite/{id}")
    @ResponseBody
    public  void removeUniversite(@PathVariable("id") Integer eqId){

        iUniversiteService.deleteUniversite(eqId);
    }


    @GetMapping("/getAllUniversite")
    @ResponseBody
    public Iterable<Unievrsite> getAllUniversite(){

        return iUniversiteService.retrieveAllUniversite();
    }

    @GetMapping("/findbyIdUniversite/{id}")
    @ResponseBody
    public Optional< Unievrsite > GetUniversitebyId(@PathVariable("id") Long Id){
        return iUniversiteService.findUniversiteById(Id);
    }


}
