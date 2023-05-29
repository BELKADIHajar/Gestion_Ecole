package com.example.GE_v2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor
public class matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "matiere")
    List<professeur> professeurs;

    public void setIdmatiere(Long idmatiere) {
        this.id = idmatiere;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setProfesseurs(List<professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<professeur> getProfesseurs() {
        return professeurs;
    }

    public matiere(String nom) {
        this.nom = nom;
    }

    public matiere(String nom, List<professeur> professeurs) {
        this.nom = nom;
        this.professeurs = professeurs;
    }

    @Override
    public String toString() {
        return "matiere{" +
                "professeurs=" + nom +
                '}';
    }




}

