package com.example.GE_v2.services;


import com.example.GE_v2.models.*;
import com.example.GE_v2.repositories.IFiliereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiliereService implements IFiliereService{

    @Autowired
    IFiliereRepository filiereRepository;
    @Override
    public Filiere saveFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public Filiere updateFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public Filiere getFiliere(Long id) {
        return filiereRepository.findById(id).get();
    }

    @Override
    public List<Filiere> getAllFilieres() {
        return filiereRepository.findAll();
    }

    @Override
    public void deleteFiliereById(Long id) {
        filiereRepository.deleteById(id);
    }

    @Override
    public void deleteAllFiliere() {
        filiereRepository.deleteAll();
    }

    @Override
    public List<Eleve> getEleveByFiliereId(Long id) {
        Filiere filiere = filiereRepository.findById(id).get();
        return filiere.getEleves();
    }

    public Filiere getFiliereById(Long FiliereId) {
        Optional<Filiere> FiliereOptional = filiereRepository.findById(FiliereId);
        return FiliereOptional.get();
    }

    public List<Filiere> getFilieresByNiveau(Niveau niveau) {
        return filiereRepository.findByNiveauNom(niveau.getNom());
    }

}
