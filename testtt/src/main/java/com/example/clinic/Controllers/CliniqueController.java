package com.example.clinic.Controllers;

import com.example.clinic.Services.CliniqueService;
import com.example.clinic.Services.IClinique;
import com.example.clinic.entity.Clinique;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class CliniqueController {

    private IClinique clinique;

    @PostMapping(value = "/addclinic",consumes = "application/json")
    public ResponseEntity<?> ShowAllUsers(@RequestBody Clinique e){
        clinique.addClinique(e);
        return new ResponseEntity<>( clinique.addClinique(e), HttpStatus.OK);
    }
}
