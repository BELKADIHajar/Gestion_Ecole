package com.example.GE_v2.services;


import com.example.GE_v2.models.matiere;
import com.example.GE_v2.models.professeur;
import com.example.GE_v2.repositories.IProfesseurtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService implements IProfesseurService{

    @Autowired
    IProfesseurtRepository professeurRepository;
    @Override
    public professeur saveProfesseur(professeur professeur) {

        return professeurRepository.save(professeur);
    }

    @Override
    public professeur updateProfesseur(professeur professeur) {

        return professeurRepository.save(professeur);
    }

    @Override
    public professeur getProfesseur(Long id) {

        return professeurRepository.findById(id).get();
    }

    @Override
    public List<professeur> getAllProfesseurs() {

        return professeurRepository.findAll();
    }

    @Override
    public void deleteProfesseurById(Long id) {
        professeurRepository.deleteById(id);
    }

    @Override
    public void deleteAllProfesseurs() {
        professeurRepository.deleteAll();
    }

    public List<professeur> getProfesseursByMatiere(matiere matiere) {
        return professeurRepository.findByMatiereNom(matiere.getNom());
    }
}
