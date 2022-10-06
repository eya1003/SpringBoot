package tn.esprit.spring.entity;
import lombok.*;
import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="Unievrsite")
public class Unievrsite  implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUniv")
    private Long idUniv; // Clé primaire

    private String nomUniv;

    @OneToMany()
    private Set<Departement> depart;
}
