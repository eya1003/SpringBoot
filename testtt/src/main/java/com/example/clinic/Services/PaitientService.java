package com.example.clinic.Services;

import com.example.clinic.Repositorys.PaitenRepository;
import com.example.clinic.entity.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PaitientService implements IPaitient{

    private PaitenRepository paitenRepository;
    @Override
    public Patient addPatient(Patient patient){
        return paitenRepository.save(patient);

    }
}
