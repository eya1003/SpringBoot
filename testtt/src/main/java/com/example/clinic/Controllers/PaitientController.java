package com.example.clinic.Controllers;

import com.example.clinic.Services.IPaitient;

import com.example.clinic.entity.Patient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaitientController {
    private IPaitient paitient;
    @PostMapping("/addpaitient")
    public ResponseEntity<?> ShowAllUsers(@RequestBody Patient e){
        paitient.addPatient(e);
        return new ResponseEntity<>( paitient.addPatient(e), HttpStatus.OK);
    }
}
