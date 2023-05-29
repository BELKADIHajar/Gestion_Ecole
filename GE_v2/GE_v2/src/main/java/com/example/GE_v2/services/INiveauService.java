package com.example.GE_v2.services;

import com.example.GE_v2.models.Filiere;
import com.example.GE_v2.models.Niveau;

import java.util.List;

public interface INiveauService {
    Niveau saveNiveau(Niveau niveau);
    Niveau updateNiveau(Niveau niveau);
    Niveau getNiveau(Long id);
    List<Niveau> getAllNiveaux();
    void deleteNiveauById(Long id);
    void deleteAllNiveaux();
    List<Filiere> getFiliereByNiveauId(Long id);
}
