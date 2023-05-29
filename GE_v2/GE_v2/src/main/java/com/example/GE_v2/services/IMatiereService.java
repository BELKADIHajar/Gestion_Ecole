package com.example.GE_v2.services;

import com.example.GE_v2.models.matiere;
import com.example.GE_v2.models.professeur;

import java.util.List;

public interface IMatiereService {
    matiere saveMatiere(matiere matiere);
    matiere updateMatiere(matiere matiere);
    matiere getMatiere(Long id);
    List<matiere> getAllMatieres();
    void deleteMatiereById(Long id);
    void deleteAllMatieres();
    List<professeur> getProfesseursByMatiereId(Long idMatiere);

}
