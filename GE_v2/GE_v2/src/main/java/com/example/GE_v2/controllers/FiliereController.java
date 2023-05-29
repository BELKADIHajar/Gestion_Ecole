package com.example.GE_v2.controllers;

import com.example.GE_v2.models.Filiere;
import com.example.GE_v2.models.Niveau;
import com.example.GE_v2.models.Site;
import com.example.GE_v2.services.FiliereService;
import com.example.GE_v2.services.NiveauService;
import com.example.GE_v2.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FiliereController {
    @Autowired
    FiliereService filiereService ;//prof
    @Autowired
    NiveauService niveauService;//matiere


    @GetMapping("/listeFiliere")
    public String listeFilieres(Model model){
        List<Filiere> listeFilieres = filiereService.getAllFilieres();
        model.addAttribute("listeFilieres", listeFilieres);
        return "listeFiliere";
    }
//Site -> Niveau
    //Niveau ->Filiere
    @GetMapping("/niveau/{id}/filiere")
    public String listefiliere(@PathVariable("id") Long idNiveau, Model model) {
        Niveau niveau = niveauService.getNiveauIdById(idNiveau);
        List<Filiere> listeFilieres = filiereService.getFilieresByNiveau(niveau) ;
        model.addAttribute("niveau", niveau);
        model.addAttribute("listeFilieres", listeFilieres);
        return "listeFiliere";
    }
    //Site -> Niveau
    //Niveau ->Filiere
    @GetMapping("/filiere/add")
    public String ajoutfiliere(Model model){
        List<Niveau> listniveaux = niveauService.getAllNiveaux();

        model.addAttribute("filiere", new Filiere());
        model.addAttribute("listniveaux",listniveaux);

        return "ajoutfiliere";
    }
    @PostMapping("/filiere/save")
    public String enregistrerfiliere(Filiere filiere){
        filiereService.saveFiliere(filiere);
        return "redirect:/listeFiliere";
    }



}
