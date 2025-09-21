package tn.esprit.gestionprojet.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.gestionprojet.entity.ProjetDetail;
import tn.esprit.gestionprojet.repository.ProjetDetailRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetDetailServiceImpl implements IProjetDetailService {
         ProjetDetailRepository projetDetailRepository;


        public List<ProjetDetail> getAllProjetDetails() {
            return projetDetailRepository.findAll();
        }

        public ProjetDetail getProjetDetailById(Long id) {
            return projetDetailRepository.findById(id).get() ;
        }

        public ProjetDetail createProjetDetail(ProjetDetail projetDetail) {
            return projetDetailRepository.save(projetDetail);
        }

        public ProjetDetail updateProjetDetail(Long id, ProjetDetail updatedProjetDetail) {
            return projetDetailRepository.save(updatedProjetDetail) ;
        }

        public void deleteProjetDetail(Long id) {
            projetDetailRepository.deleteById(id);
        }

}
