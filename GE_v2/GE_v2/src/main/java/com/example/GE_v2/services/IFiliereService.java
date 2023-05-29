package com.example.GE_v2.services;

import com.example.GE_v2.models.Eleve;
import com.example.GE_v2.models.Filiere;

import java.util.List;

public interface IFiliereService {
    Filiere saveFiliere(Filiere filiere);
    Filiere updateFiliere(Filiere filiere);
    Filiere getFiliere(Long id);
    List<Filiere> getAllFilieres();
    void deleteFiliereById(Long id);
    void deleteAllFiliere();

    List<Eleve> getEleveByFiliereId(Long id);
}
