package com.example.GE_v2.services;


import com.example.GE_v2.models.*;
import com.example.GE_v2.repositories.INiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauService implements INiveauService{

    @Autowired
    INiveauRepository niveauRepository;
    @Override
    public Niveau saveNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau updateNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau getNiveau(Long id) {
        return niveauRepository.findById(id).get();
    }

    @Override
    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    @Override
    public void deleteNiveauById(Long id) {
        niveauRepository.deleteById(id);
    }

    @Override
    public void deleteAllNiveaux() {
        niveauRepository.deleteAll();
    }

    @Override
    public List<Filiere> getFiliereByNiveauId(Long id) {
        Niveau niveau = niveauRepository.findById(id).get();
        return niveau.getFilieres();
    }

    public Niveau getNiveauIdById(Long NiveauId) {
        Optional<Niveau> NiveauOptional = niveauRepository.findById(NiveauId);
        return NiveauOptional.get();
    }
    public List<Niveau> getNiveauxBySite(Site site) {
        return niveauRepository.findBySiteNom(site.getNom());
    }
}

