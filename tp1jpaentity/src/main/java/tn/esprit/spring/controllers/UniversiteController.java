package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repositories.UniversiteRepository;
import tn.esprit.spring.services.IUniversiteService;

import java.util.Set;

@RestController
@RequestMapping("/UniversiteC")
public class UniversiteController {
    @Autowired
    IUniversiteService iUniversiteService;
    @GetMapping("/")
    public String hello(){return "HEllo universite";}

    @GetMapping("/getAllUniversite")
    public Iterable<Universite>  GetAllUniversite(){
        return  iUniversiteService.retrieveAllUniversite();
    }
    @PutMapping(value = "/affectationUni_dep/{Uni-id}/{dep-id}")
    public void affectationUniversiteDepartement(@PathVariable("Uni-id") Long UniId , @PathVariable("dep-id") Long depId )
    {
        iUniversiteService.assignUniversiteToDepartement(UniId,depId);
    }

    @GetMapping("/reccupererDepartementByUniversite/{idUniv}")
    public Set<Departement> reccupererDepartementByUniversite(@PathVariable("idUniv") Long UniId){
        return  iUniversiteService.retrieveDepartementsByUniversite(UniId);
    }
}
