package tn.esprit.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;

import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Pagina;
import tn.esprit.spring.entity.Professeur;
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
    @CrossOrigin(origins = "http://localhost:4200")
    public  Departement  GetDepartementbyId(@PathVariable("departement-id") Long Id){
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
/*
    @GetMapping("/findAllEPaginate")
    @CrossOrigin(origins = "http://localhost:4200")
    public Pagina getProfesseurs(@RequestParam Optional<String> Classe,
                                 @RequestParam Optional<Integer> page,
                                 @RequestParam Optional<Integer> size)
    {
        Page<Departement> departements = null;
        departements= professeurRepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        size.orElse(10)
                )
        );
        Pagina res = new Pagina(departements.getContent(), departements.getTotalPages(),
                departements.getNumber(), departements.getSize());

        return res;
    }
    
 */
}
