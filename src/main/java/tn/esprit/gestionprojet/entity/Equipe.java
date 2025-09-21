package tn.esprit.gestionprojet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Enumerated(EnumType.STRING)
    private Domaine domaine;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Projet> projets = new ArrayList<Projet>();
}
