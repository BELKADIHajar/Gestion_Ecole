package com.example.GE_v2.controllers;

import com.example.GE_v2.models.Site;
import com.example.GE_v2.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SiteController {
    //ajoutSite
    @Autowired
    SiteService siteService;

    @GetMapping("/Sites")
    public String listsites(Model model){
        List<Site> listsites = siteService.getAllSites();
        model.addAttribute("listsites", listsites);
        return "Sites";
    }

    @GetMapping("/sites/add")
    public String ajoutsite(Model model){
        List<Site> listsites = siteService.getAllSites();
        model.addAttribute("site", new Site());
        model.addAttribute("listsites",listsites);
        return "ajoutSite";
    }

    @PostMapping("/sites/save")
    public String enregistrersite(Site site){
        siteService.saveSite(site);
        return "redirect:/Sites";
    }
}
