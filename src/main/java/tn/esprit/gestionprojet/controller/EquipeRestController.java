package tn.esprit.gestionprojet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.entity.Equipe;
import tn.esprit.gestionprojet.service.EquipeServiceImpl;

import java.util.List;

@Tag(name = "Gestion equipe")
@RestController
@AllArgsConstructor
@RequestMapping("/api/equipes")
public class EquipeRestController {

    EquipeServiceImpl equipeService;

    @Operation(description = "Permet de récupérer la liste de toutes les équipes disponibles.")
    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    @Operation(description = "Permet de récupérer une équipe spécifique en utilisant son identifiant.")
    @GetMapping("/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeService.getEquipeById(id);
    }


    @Operation(description = "Permet d’ajouter une nouvelle équipe.")
    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeService.createEquipe(equipe);
    }

    @Operation(description = "Permet de mettre à jour les informations d’une équipe existante en utilisant son identifiant.")
    @PutMapping("/{id}")
    public Equipe updateEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
        return equipeService.updateEquipe(id, equipe);
    }

    @Operation(description = "Permet de supprimer une équipe en utilisant son identifiant.")
    @DeleteMapping("/{id}")
    public void deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
    }

    @Operation(description = "Permet d’affecter un projet à une équipe donnée via leurs identifiants.")
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{equipeId}")
    public void affecterProjetAProjetDetail(@PathVariable("projet-id") Long projetId,
                                            @PathVariable("equipeId") Long equipeId) {
        equipeService.assignProjetToEquipe(projetId, equipeId);
    }

    @Operation(description = "Permet de désaffecter un projet d’une équipe via leurs identifiants.")
    @PutMapping("/desaffecter-Projet-From-Equipe/{projet-id}/{equipeId}")
    public void desaffecterProjetFromEquipe(@PathVariable("projet-id") Long projetId,
                                            @PathVariable("equipeId") Long equipeId) {
        equipeService.desaffecterProjetFromEquipe(projetId, equipeId);
    }
}
