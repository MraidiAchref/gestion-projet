package tn.esprit.gestionprojet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.entity.Projet;
import tn.esprit.gestionprojet.service.ProjetServiceImpl;

import java.util.List;

@Tag(name = "Gestion Projet")
@RestController
@AllArgsConstructor
@RequestMapping("/api/projets")
public class ProjetRestController {

    ProjetServiceImpl projetService;

    @Operation(description = "Permet de récupérer la liste de tous les projets disponibles dans la base de données.")
    @GetMapping
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    @Operation(description = "Permet de récupérer un projet spécifique à partir de son identifiant.")
    @GetMapping("/{id}")
    public Projet getProjetById(@PathVariable Long id) {
        return projetService.getProjetById(id);
    }

    @Operation(description = "Permet d’ajouter un nouveau projet avec ses détails associés, puis de les affecter automatiquement.")
    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet createProjet(@RequestBody Projet projet) {
        return projetService.addProjetAndProjetDetailAndAssign(projet);
    }

    @Operation(description = "Permet de modifier les informations d’un projet existant en fournissant son ID.")
    @PutMapping("/{id}")
    public Projet updateProjet(@PathVariable Long id, @RequestBody Projet projet) {
        return projetService.updateProjet(id, projet);
    }

    @Operation(description = "Ajoute un projet et l’affecte à un ProjetDetail existant via son identifiant.")
    @PutMapping("/creer-projet-et-affecter-projet-detail-a-projet/{projet-details-id}")
    public Projet affecterProjetAProjetDetail(@RequestBody Projet projet,
                                              @PathVariable("projet-details-id") Long projetDetailsId) {
        return projetService.addProjetAndAssignProjetToProjetDetail(projet, projetDetailsId);
    }

    @Operation(description = "Permet de désassocier un ProjetDetail précédemment lié à un projet.")
    @PutMapping("/Desaffecter-ProjetDetail-From-Projet/{projet-id}")
    public Projet DesaffecterProjetDetailFromProjet(@PathVariable("projet-id") Long projetId) {
        return projetService.DesaffecterProjetDetailFromProjet(projetId);
    }

    @Operation(description = "Supprime un projet de la base de données en utilisant son ID.")
    @DeleteMapping("/{id}")
    public void deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
    }

    @Operation(description = "Permet d’associer un ProjetDetail existant à un projet déjà existant.")
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecterProjetAProjetDetail(@PathVariable("projet-id") Long projetId,
                                            @PathVariable("projet-details-id") Long projetDetailsId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailsId);
    }
}
