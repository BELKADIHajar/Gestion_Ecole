package com.example.GE_v2.controllers;

import com.example.GE_v2.models.matiere;
import com.example.GE_v2.models.professeur;
import com.example.GE_v2.repositories.IProfesseurtRepository;
import com.example.GE_v2.services.MatiereService;
import com.example.GE_v2.services.ProfesseurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfesseurController {
    @Autowired
    ProfesseurService professeurService;
    @Autowired
    MatiereService matiereService;

    @GetMapping("/matiere/{id}/professeurs")
    public String listeProfesseurs(@PathVariable("id") Long matiereId, Model model) {
        matiere matiere = matiereService.getMatiereById(matiereId);
        List<professeur> listeProfesseurs = professeurService.getProfesseursByMatiere(matiere);
        model.addAttribute("matiere", matiere);
        model.addAttribute("listeProfesseurs", listeProfesseurs);
        return "listeProfesseurs";
    }


    @GetMapping("/professeur/add")
    public String ajoutprofesseur(Model model){
        List<matiere> listmatieres = matiereService.getAllMatieres();

        model.addAttribute("professeur", new professeur());
        model.addAttribute("listmatieres",listmatieres);
        return "ajoutprofesseur";
    }

    @PostMapping("/professeurs/save")
    public String enregistrerProf(professeur professeur){
        professeurService.saveProfesseur(professeur);

        return "redirect:/courses" ;
    }

    @GetMapping("/professeurs")
    public String professeurList(ModelMap modelMap) {
        List<professeur> Listprofesseurs = professeurService.getAllProfesseurs();
        modelMap.addAttribute("Listprofesseurs",Listprofesseurs);
        return "professeurs";
    }





///////////////////////////////////////////////////////////////

/*


    @RequestMapping("/deleteProfesseur")
    public String deleteProfesseur(@RequestParam("id") Long id, ModelMap modelMap){
        professeurService.deleteProfesseurById(id);
        List<professeur> professeursController = professeurService.getAllProfesseurs();
        modelMap.addAttribute("productJsp",professeursController);
        return "ProfesseursList";
    }
    @RequestMapping("/showProfesseur")
    public String showProfesseur(@RequestParam("id") Long id, ModelMap modelMap){
        professeur profController = professeurService.getProfesseur(id);
        modelMap.addAttribute("professeurJSP",profController);
        return "EditProfesseur";
    }
*/


}
