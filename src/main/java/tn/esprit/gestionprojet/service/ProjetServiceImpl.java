package tn.esprit.gestionprojet.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.entity.Projet;
import tn.esprit.gestionprojet.entity.ProjetDetail;
import tn.esprit.gestionprojet.repository.ProjetDetailRepository;
import tn.esprit.gestionprojet.repository.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {
        ProjetRepository projetRepository;
        ProjetDetailRepository projetDetailRepository;
        public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
            Projet projet = projetRepository.findById(projetId).get();
            ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
            // on set le fils dans le parent :
            projet.setProjetDetail(projetDetail);
            projetRepository.save(projet);
        }

        public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
            ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
              // on set le fils dans le parent :
            projet.setProjetDetail(projetDetail);
            return projetRepository.save(projet);
        }
        public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
            Projet projet = projetRepository.findById(projetId).get();
            projet.setProjetDetail(null);
            return projetRepository.save(projet);
        }

        public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
            return projetRepository.save(projet);
        }
        public List<Projet> getAllProjets() {
            return projetRepository.findAll();
        }

        public Projet getProjetById(Long id) {
            return projetRepository.findById(id).get() ;
        }



        public Projet updateProjet(Long id, Projet updatedProjet) {
            return projetRepository.save(updatedProjet) ;
        }

        public void deleteProjet(Long id) {
            projetRepository.deleteById(id);
        }



}
