package tn.esprit.spring.entity;
import lombok.*;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="Contrat")
public class Contrat implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat; // Clé primaire
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    private Date dateFinContrat;
    private Boolean archive;
    private Integer montatContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite ;

    @ManyToOne
    Etudiant etudiant;

    }

