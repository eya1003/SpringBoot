package com.example.clinic.Services;

import com.example.clinic.Repositorys.CliniqueRepository;
import com.example.clinic.entity.Clinique;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CliniqueService implements IClinique{
    private CliniqueRepository repository;
    @Override

    public Clinique addClinique(Clinique e){
       return repository.save(e);
    }



}
