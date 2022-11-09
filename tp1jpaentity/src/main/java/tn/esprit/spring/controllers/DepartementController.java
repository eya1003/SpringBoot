package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;

import tn.esprit.spring.services.IDepartementService;


import java.util.Optional;

@RestController
@RequestMapping("/DepartementC")
public class DepartementController {

    @Autowired
    IDepartementService iDepartementService;

    @GetMapping("/")
    public Iterable<Departement>  GetAllDepartement(){
        return iDepartementService.retrieveAllDepartement();
    }
    @GetMapping("/DepartementById/{departement-id}")
    public Optional< Departement > GetDepartementbyId(@PathVariable("departement-id") Long Id){
        return iDepartementService.findDepartementById(Id);
    }
    @PostMapping("/addDepartement")
    @ResponseBody
    public void addDepartement(@RequestBody Departement departement) {
        iDepartementService.ajouterDepartement(departement);
    }

    @PutMapping("/updateDepartement")
    @ResponseBody
    public void updateDepartement(@RequestBody Departement departement) {
        iDepartementService.updateDepartement(departement);
    }

    @DeleteMapping("/deleteDepartement/{departement-id}")
    @ResponseBody
    public void deleteEtudiant(@PathVariable("departement-id") Integer departementId ) {
        iDepartementService.deleteDepartement(departementId);
    }
}
