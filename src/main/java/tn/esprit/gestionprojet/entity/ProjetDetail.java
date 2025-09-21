package tn.esprit.gestionprojet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String technologie;
    private Long cout;

    @OneToOne(mappedBy = "projetDetail" )
    @ToString.Exclude
    @JsonIgnore
    private Projet projet ;

    private LocalDate dateDebut;
}