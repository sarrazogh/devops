package tn.esprit.tpfoyer.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
@Tag(name = "Gestion Chambre")

public class ChambreRestController {
    @Autowired
    IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }

    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
    @GetMapping("trouverchambreparType/{type-chambre}")
    public List<Chambre> trouverchambreparType(@PathVariable("type-chambre") TypeChambre tch) {
        List<Chambre> listchambre = chambreService.searchChambrepartype(tch);
        return listchambre;
    }
    @GetMapping("trouverchambreparnum/{numero-chambre}")
    public Chambre trouverchambreparnum(@PathVariable("numero-chambre") Long num) {
        Chambre ch = chambreService.searchChambreparnumerochambre(num);
        return ch;
    }
    @PostMapping("/ajouter-chambre-reservation-etudiant")
    public Chambre addProjetAndProjetDetail(@RequestBody Chambre p) {
        Chambre projet = chambreService.addProjetAndProjetDetailAndAssign(p);
        return projet;
    }
}
