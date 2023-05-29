package com.example.GE_v2.services;

import com.example.GE_v2.models.matiere;
import com.example.GE_v2.models.professeur;
import com.example.GE_v2.repositories.IMatiereRepository;
import com.example.GE_v2.repositories.IProfesseurtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService implements IMatiereService{

    @Autowired
    IMatiereRepository matiereRepository;
    @Override
    public matiere saveMatiere(matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public matiere getMatiereById(Long matiereId) {
            Optional<matiere> matiereOptional = matiereRepository.findById(matiereId);
                return matiereOptional.get();
    }

    @Override
    public matiere updateMatiere(matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public matiere getMatiere(Long id) {
        return matiereRepository.findById(id).get();
    }
    @Override
    public List<professeur> getProfesseursByMatiereId(Long idMatiere) {
        matiere matiere = matiereRepository.findById(idMatiere).get();
        return matiere.getProfesseurs();
    }


    @Override
    public List<matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public void deleteMatiereById(Long id) {
        matiereRepository.deleteById(id);
    }

    @Override
    public void deleteAllMatieres() {
        matiereRepository.deleteAll();
    }
}
