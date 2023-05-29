package com.example.GE_v2.services;

import com.example.GE_v2.models.Niveau;
import com.example.GE_v2.models.Site;

import java.util.List;

public interface ISiteService {
    Site saveSite(Site site);
    Site updateSite(Site site);
    Site getSite(Long id);
    List<Site> getAllSites();
    void deleteSiteById(Long id);
    void deleteAllSites();
    List<Niveau> getNiveauxBySiteId(Long id);
}
