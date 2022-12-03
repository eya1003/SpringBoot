package com.example.clinic.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;

    private String nomMedecin;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private int prixConsultation;

    @ManyToMany(mappedBy = "medecin")
    private Set<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    private Set <RendezVous> rendezVous;
}
