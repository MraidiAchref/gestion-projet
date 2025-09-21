package tn.esprit.gestionprojet.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.entity.Equipe;
import tn.esprit.gestionprojet.entity.Projet;
import tn.esprit.gestionprojet.repository.EquipeRepository;
import tn.esprit.gestionprojet.repository.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {
         EquipeRepository equipeRepository;
         ProjetRepository projetRepository ;
        public void assignProjetToEquipe(Long projetId, Long equipeId) {
            Projet projet = projetRepository.findById(projetId).get();
            Equipe equipe = equipeRepository.findById(equipeId).get();
            // on set le fils dans le parent :
            equipe.getProjets().add(projet);
            equipeRepository.save(equipe);
        }

        public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
            Projet projet = projetRepository.findById(projetId).get();
            Equipe equipe = equipeRepository.findById(equipeId).get();
             // on enlève le fils du parent :
            equipe.getProjets().remove(projet);
            equipeRepository.save(equipe);
        }


    public List<Equipe> getAllEquipes() {
            return equipeRepository.findAll();
        }

        public Equipe getEquipeById(Long id) {
            return equipeRepository.findById(id).get() ;
        }

        public Equipe createEquipe(Equipe equipe) {
            return equipeRepository.save(equipe);
        }

        public Equipe updateEquipe(Long id, Equipe updatedEquipe) {
            return equipeRepository.save(updatedEquipe) ;
        }

        public void deleteEquipe(Long id) {
            equipeRepository.deleteById(id);
        }

}
