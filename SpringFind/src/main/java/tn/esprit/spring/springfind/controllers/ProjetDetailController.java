package tn.esprit.spring.springfind.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.springfind.entities.ProjetDetail;
import tn.esprit.spring.springfind.repositories.ProjetDetailRepository;
import tn.esprit.spring.springfind.repositories.ProjetRepository;
import tn.esprit.spring.springfind.services.ProjetDetailImp;
import tn.esprit.spring.springfind.services.ProjetServiceImp;

@SpringBootApplication
@RestController
@RequestMapping("/details")
public class ProjetDetailController {
    @Autowired
    private ProjetDetailRepository repository;

    @Autowired
    private ProjetDetailImp serviceDetail;
/*
    @PostMapping("/registerDetail")
    public ResponseEntity<?> Ajouter(@RequestBody ProjetDetail detail){
        serviceDetail.register(detail);
        return new ResponseEntity<>(serviceDetail.ajout(detail), HttpStatus.CREATED);
    }
*/
    @GetMapping("/getalldetail")
    public ResponseEntity<?> getall(){
        serviceDetail.getall();
        return new ResponseEntity<>(serviceDetail.getall(),HttpStatus.OK);
    }

    @GetMapping("/getdetail/{id}")
    public ResponseEntity<?> getone(@PathVariable Long id){
        serviceDetail.getone(id);
        return  new ResponseEntity<>(serviceDetail.getone(id),HttpStatus.OK);
    }


}
