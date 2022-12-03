package com.example.clinic.Services;

import com.example.clinic.Repositorys.CliniqueRepository;
import com.example.clinic.Repositorys.MedecinRepository;
import com.example.clinic.entity.Medecin;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MedicienService implements IMedicin{

    private MedecinRepository MedecinRepository;
    private CliniqueRepository CliniqueReppository;



    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId){

        if(!CliniqueReppository.findById(cliniqueId).isPresent()){
          log.error("cli");
        }
        CliniqueReppository.findById(cliniqueId).get().getMedecin().add(medecin);
        return MedecinRepository.save(medecin);

    }

}
