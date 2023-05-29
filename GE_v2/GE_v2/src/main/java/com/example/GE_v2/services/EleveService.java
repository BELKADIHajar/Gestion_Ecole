package com.example.GE_v2.services;

import com.example.GE_v2.models.Eleve;
import com.example.GE_v2.models.Filiere;
import com.example.GE_v2.models.matiere;
import com.example.GE_v2.repositories.IEleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EleveService implements IEleveService{

    @Autowired
    IEleveRepository eleveRepository;
    @Override
    public Eleve saveEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve updateEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @Override
    public Eleve getEleve(Long id) {
        return eleveRepository.findById(id).get();
    }

    @Override
    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    @Override
    public void deleteEleveById(Long id) {
        eleveRepository.deleteById(id);
    }

    @Override
    public void deleteAllEleves() {
        eleveRepository.deleteAll();
    }

    @Override
    public List<Eleve> getElevesByFiliere(Filiere filiere) {
        return eleveRepository.findByFiliereNom(filiere.getNom());
    }

    public Eleve getEleveById(Long EleveId){
        Optional<Eleve> EleveOptional = eleveRepository.findById(EleveId);
        return EleveOptional.get();
    }
}
