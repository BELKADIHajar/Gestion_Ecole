package com.example.GE_v2.services;

import com.example.GE_v2.models.professeur;

import java.util.List;

public interface IProfesseurService {
    professeur saveProfesseur(professeur professeur);
    professeur updateProfesseur(professeur professeur);
    professeur getProfesseur(Long id);
    List<professeur> getAllProfesseurs();
    void deleteProfesseurById(Long id);
    void deleteAllProfesseurs();
}
