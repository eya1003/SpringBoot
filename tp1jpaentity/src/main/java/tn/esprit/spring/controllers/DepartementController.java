package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;

import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IDepartementService;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/DepartementC")
public class DepartementController {

    @Autowired
    IDepartementService iDepartementService;

    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<Departement>  GetAllDepartement(){
        return iDepartementService.retrieveAllDepartement();
    }
    @GetMapping("/DepartementById/{departement-id}")
    public Optional< Departement > GetDepartementbyId(@PathVariable("departement-id") Long Id){
        return iDepartementService.findDepartementById(Id);
    }
    @PostMapping("/addDepartement")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addDepartement(@RequestBody Departement departement) {
        iDepartementService.ajouterDepartement(departement);
    }

    @PutMapping("/updateDepartement")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void updateDepartement(@RequestBody Departement departement) {
        iDepartementService.updateDepartement(departement);
    }

    @DeleteMapping("/deleteDepartement/{departement-id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void deleteDepartement(@PathVariable("departement-id") Long departementId ) {
        iDepartementService.deleteDepartement(departementId);
    }
/*
    @GetMapping("/getEtudiantsByDepartement/{id-depart}")
    @ResponseBody
    public void getEtudiantsByDepartement(@PathVariable("id-depart")Long departementId ) {
        iDepartementService.getEtudiantsByDepar(departementId);
    }

 */
    @GetMapping("/getEtudiantsByDepartement")
    public List<Etudiant> getEtudiantsByDepartement(@RequestParam Long idDepartement) {
        return iDepartementService.getEtudiantsByDepar(idDepartement);
    }
}
