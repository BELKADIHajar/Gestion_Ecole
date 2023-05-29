package com.example.GE_v2.services;


import com.example.GE_v2.models.Niveau;
import com.example.GE_v2.models.Site;
import com.example.GE_v2.models.matiere;
import com.example.GE_v2.repositories.ISiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService implements ISiteService{

    @Autowired
    ISiteRepository siteRepository;
    @Override
    public Site saveSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public Site updateSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public Site getSite(Long id) {
        return siteRepository.findById(id).get();
    }

    @Override
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @Override
    public void deleteSiteById(Long id) {
        siteRepository.deleteById(id);
    }

    @Override
    public void deleteAllSites() {
        siteRepository.deleteAll();
    }

    @Override
    public List<Niveau> getNiveauxBySiteId(Long id) {
        Site site = siteRepository.findById(id).get();
        return site.getNiveaux();
    }

    public Site getSiteById(Long SiteId) {
        Optional<Site> SiteOptional = siteRepository.findById(SiteId);
        return SiteOptional.get();
    }
}

