package com.example.GE_v2.services;

import com.example.GE_v2.models.Eleve;
import com.example.GE_v2.models.Filiere;

import java.util.List;

public interface IEleveService {

    Eleve saveEleve(Eleve eleve);
    Eleve updateEleve(Eleve eleve);
    Eleve getEleve(Long id);
    List<Eleve> getAllEleves();
    void deleteEleveById(Long id);
    void deleteAllEleves();
    public List<Eleve> getElevesByFiliere(Filiere filiere);
}
