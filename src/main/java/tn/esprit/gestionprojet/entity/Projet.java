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
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sujet;

    @OneToOne( cascade = CascadeType.ALL)
    private ProjetDetail projetDetail;

    @ManyToMany(mappedBy = "projets",cascade = CascadeType.ALL)
    private List<Equipe> equipes = new ArrayList<Equipe>() ;
}