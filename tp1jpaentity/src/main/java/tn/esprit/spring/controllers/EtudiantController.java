package tn.esprit.spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.IEtudiantService;

@RestController
@RequestMapping("/EtudiantC")

public class EtudiantController {
   @Autowired
    IEtudiantService etudiantService;

   @GetMapping("/")
    public String hello(){return "HEllo word3";}
    @PostMapping("/addEtudiant")
    @ResponseBody
    public void addEtudiant(@RequestBody Etudiant etudiant){
        etudiantService.ajouter_etudiant(etudiant);
    }

}
