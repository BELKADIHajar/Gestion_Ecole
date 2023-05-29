package com.example.GE_v2.controllers;

import com.example.GE_v2.models.matiere;
import com.example.GE_v2.services.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MatiereController {

    @Autowired
    MatiereService matiereService;
    @GetMapping("/courses")
    public String listmatieres(Model model){
        List<matiere> listmatieres = matiereService.getAllMatieres();
        model.addAttribute("listmatieres", listmatieres);
        return "courses";
    }
    @GetMapping("/matieres/add")
    public String ajoutmatiere(Model model){
        List<matiere> listmatieres= matiereService.getAllMatieres();
        model.addAttribute("matiere", new matiere());
        model.addAttribute("listmatieres",listmatieres);
        return "ajoutmatiere";
    }
    @PostMapping("/matieres/save")
    public String enregistrermatiere(matiere mat){
        matiereService.saveMatiere(mat);
        return "redirect:/courses";
    }

}
