package tn.esprit.gestionprojet.service;

import tn.esprit.gestionprojet.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    public void assignProjetToEquipe(Long projetId, Long equipeId) ;
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) ;

        public List<Equipe> getAllEquipes() ;

    public Equipe getEquipeById(Long id) ;
    public Equipe createEquipe(Equipe equipe) ;

    public Equipe updateEquipe(Long id, Equipe updatedEquipe) ;

    public void deleteEquipe(Long id) ;


    }

