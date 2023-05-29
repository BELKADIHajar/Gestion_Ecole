package com.example.GE_v2.controllers;

import com.example.GE_v2.models.Niveau;
import com.example.GE_v2.models.Site;
import com.example.GE_v2.models.matiere;
import com.example.GE_v2.models.professeur;
import com.example.GE_v2.services.NiveauService;
import com.example.GE_v2.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NiveauController {
    @Autowired
    NiveauService niveauService;//prof
    @Autowired
    SiteService siteService;//matiere


    @GetMapping("/listeNiveaux")
    public String listsites(Model model){
        List<Niveau> listeNiveaux = niveauService.getAllNiveaux();
        model.addAttribute("listeNiveaux", listeNiveaux);
        return "listeNiveaux";
    }
    @GetMapping("/site/{id}/niveaux")
    public String listeniveaux(@PathVariable("id") Long SiteId, Model model) {
        Site site = siteService.getSiteById(SiteId);
        List<Niveau> listeNiveaux = niveauService.getNiveauxBySite(site);
        model.addAttribute("site", site);
        model.addAttribute("listeNiveaux", listeNiveaux);
        return "listeNiveaux";
    }

    @GetMapping("/niveau/add")
    public String ajoutniveau(Model model){
        List<Site> listsites = siteService.getAllSites();

        model.addAttribute("niveau", new Niveau());
        model.addAttribute("listsites",listsites);

        return "ajoutniveau";
    }
    @PostMapping("/niveaux/save")
    public String enregistrerniveau(Niveau niveau){
        niveauService.saveNiveau(niveau);
        return "redirect:/listeNiveaux";
    }



}
