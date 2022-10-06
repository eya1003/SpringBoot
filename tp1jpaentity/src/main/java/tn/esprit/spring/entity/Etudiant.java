
package tn.esprit.spring.entity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option opt ;


// Constructeur et accesseurs (getters) et mutateurs (setters)


    @OneToMany( mappedBy="etudiant")
    private Set<Contrat> contrat;

    @ManyToOne
    Departement departement;

    @ManyToMany()
    private Set<Equipe> equipes;
}

