package tn.esprit.gestionprojet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionprojet.entity.Equipe;
import tn.esprit.gestionprojet.entity.Projet;
@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {

}
