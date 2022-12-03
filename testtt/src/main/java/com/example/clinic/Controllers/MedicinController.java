package com.example.clinic.Controllers;

import com.example.clinic.Services.IMedicin;
import com.example.clinic.Services.MedicienService;
import com.example.clinic.entity.Clinique;
import com.example.clinic.entity.Medecin;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MedicinController{
    private IMedicin  medicien;
    @PostMapping("/addclinic/{id}")
    public ResponseEntity<?> ShowAllUsers(@RequestBody Medecin  e, @PathVariable("id") Long id){
        medicien.addMedecinAndAssignToClinique(e,id);
        return new ResponseEntity<>(  medicien.addMedecinAndAssignToClinique(e,id), HttpStatus.OK);
    }

}
