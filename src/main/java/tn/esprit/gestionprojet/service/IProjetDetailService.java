package tn.esprit.gestionprojet.service;

import tn.esprit.gestionprojet.entity.ProjetDetail;

import java.util.List;

public interface IProjetDetailService {
    public List<ProjetDetail> getAllProjetDetails() ;
    
    public ProjetDetail getProjetDetailById(Long id) ;
    public ProjetDetail createProjetDetail(ProjetDetail projetDetail) ;

    public ProjetDetail updateProjetDetail(Long id, ProjetDetail updatedProjetDetail) ;

    public void deleteProjetDetail(Long id) ;


    }

