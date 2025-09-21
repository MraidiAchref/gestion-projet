package tn.esprit.gestionprojet.service;

import tn.esprit.gestionprojet.entity.Projet;

import java.util.List;

public interface IProjetService {
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) ;
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) ;

    public List<Projet> getAllProjets() ;
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) ;

    public Projet getProjetById(Long id) ;
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) ;

    public Projet updateProjet(Long id, Projet updatedProjet) ;

    public void deleteProjet(Long id) ;


    }

