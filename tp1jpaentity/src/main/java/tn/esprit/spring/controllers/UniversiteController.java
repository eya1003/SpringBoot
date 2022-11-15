package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repositories.DepartementRepository;
import tn.esprit.spring.services.IUniversiteService;

import java.util.Optional;

@RestController
@RequestMapping("/UniversiteC")
public class UniversiteController {

    @Autowired
    IUniversiteService iUniversiteService;

    @PostMapping("/addUniversite")
    @ResponseBody
    public void addUniversite(@RequestBody Universite univ){
        iUniversiteService.ajouter_Universite(univ);
    }

    @PutMapping("/updateUniversite")
    @ResponseBody
    public Universite updateUniversite(@RequestBody Universite e){
        Universite eq= iUniversiteService.updateUniversite(e);
        return  eq;
    }

    @DeleteMapping("/daleteUniversite/{id}")
    @ResponseBody
    public  void removeUniversite(@PathVariable("id") Integer eqId){

        iUniversiteService.deleteUniversite(eqId);
    }


    @GetMapping("/getAllUniversite")
    @ResponseBody
    public Iterable<Universite> getAllUniversite(){

        return iUniversiteService.retrieveAllUniversite();
    }

    @GetMapping("/findbyIdUniversite/{id}")
    @ResponseBody
    public Optional< Universite > GetUniversitebyId(@PathVariable("id") Long Id){
        return iUniversiteService.findUniversiteById(Id);
    }

    @PutMapping( value ="/affectationUni_dep/{Uni-id}/{dep-id}")
    public void affectationUniversiteDepartement(@PathVariable("Uni-id") Long UniId ,@PathVariable("dep-id") Long depId )
    {
        iUniversiteService.assignUniversiteToDepartement(UniId,depId);
    }
    @PutMapping(value = "/affecter-univ-departement/{univid}/{departementid}")
    public void affecterunivToDepartement(@PathVariable("univid") Long univ,
                                              @PathVariable("departementid") Long departementId)
    {
        iUniversiteService.assignUniversiteToDepartement(univ,departementId);
    }


}
