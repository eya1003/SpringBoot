package tn.esprit.spring.entity;
import lombok.*;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="Equipe")
public class Equipe implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau ;

    @ManyToMany(mappedBy="equipes")
    private Set<Etudiant> etudiantEquipe;

    @OneToOne
    private DetailEquipe equipeDetail;
}
