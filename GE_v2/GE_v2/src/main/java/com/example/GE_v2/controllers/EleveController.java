package com.example.GE_v2.controllers;

import com.example.GE_v2.models.Eleve;
import com.example.GE_v2.models.Filiere;
import com.example.GE_v2.models.matiere;
import com.example.GE_v2.models.professeur;
import com.example.GE_v2.services.EleveService;
import com.example.GE_v2.services.FiliereService;
import com.example.GE_v2.services.MatiereService;
import com.example.GE_v2.services.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EleveController {
    @Autowired
    EleveService eleveService ; //Prof
    @Autowired
    FiliereService filiereService; // Matiere

    @GetMapping("/filiere/{id}/eleve")
    public String listeEleves(@PathVariable("id") Long filiereId, Model model) {
        Filiere filiere = filiereService.getFiliereById(filiereId);
        List<Eleve> listeEleves = eleveService.getElevesByFiliere(filiere);
        model.addAttribute("filiere", filiere);
        model.addAttribute("listeEleves", listeEleves);
        return "listeEleves";
    }

    @GetMapping("/eleve/add")
    public String ajouteleve(Model model){
        List<Filiere> listeFilieres = filiereService.getAllFilieres();
        model.addAttribute("eleve", new Eleve());
        model.addAttribute("listeFilieres",listeFilieres);
        return "ajouteleve";
    }

    @PostMapping("/eleves/save")
    public String enregistrerEleve(Eleve eleve){
        eleveService.saveEleve(eleve);
        return "redirect:/eleves" ;
    }

    @GetMapping("/eleves")
    public String EleveList(ModelMap modelMap) {
        List<Eleve> listeEleves = eleveService.getAllEleves();
        modelMap.addAttribute("listeEleves",listeEleves);
        return "listeEleves";
    }
}
