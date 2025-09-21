package tn.esprit.gestionprojet.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionprojet.entity.ProjetDetail;
import tn.esprit.gestionprojet.service.ProjetDetailServiceImpl;

import java.util.List;

@Tag(name = "Gestion projet detail")
@RestController
@AllArgsConstructor
@RequestMapping("/api/projetDetails")
public class ProjetDetailRestController {

    ProjetDetailServiceImpl projetDetailService;

    @Operation(description = "Permet de récupérer la liste de tous les détails de projet disponibles.")
    @GetMapping
    public List<ProjetDetail> getAllProjetDetails() {
        return projetDetailService.getAllProjetDetails();
    }

    @Operation(description = "Permet de récupérer un détail de projet spécifique en utilisant son identifiant.")
    @GetMapping("/{id}")
    public ProjetDetail getProjetDetailById(@PathVariable Long id) {
        return projetDetailService.getProjetDetailById(id);
    }

    @Operation(description = "Permet d’ajouter un nouveau détail de projet.")
    @PostMapping
    public ProjetDetail createProjetDetail(@RequestBody ProjetDetail projetDetail) {
        return projetDetailService.createProjetDetail(projetDetail);
    }

    @Operation(description = "Permet de mettre à jour les informations d’un détail de projet existant à partir de son identifiant.")
    @PutMapping("/{id}")
    public ProjetDetail updateProjetDetail(@PathVariable Long id, @RequestBody ProjetDetail projetDetail) {
        return projetDetailService.updateProjetDetail(id, projetDetail);
    }

    @Operation(description = "Permet de supprimer un détail de projet en utilisant son identifiant.")
    @DeleteMapping("/{id}")
    public void deleteProjetDetail(@PathVariable Long id) {
        projetDetailService.deleteProjetDetail(id);
    }
}
