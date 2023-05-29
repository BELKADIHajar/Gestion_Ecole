package com.example.GE_v2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;
    private String nom;

    //Site
    @ManyToOne
    @JoinColumn(name = "id")
    private Site site;

    //Filiere
    @OneToMany(mappedBy = "niveau")
    List<Filiere> filieres;

    public Long getIdNiveau() {
        return idNiveau;
    }

    public String getNom() {
        return nom;
    }

    public Site getSite() {
        return site;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
}
