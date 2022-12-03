package com.example.clinic.Services;

import com.example.clinic.entity.Medecin;

public interface IMedicin {
    Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);
}
