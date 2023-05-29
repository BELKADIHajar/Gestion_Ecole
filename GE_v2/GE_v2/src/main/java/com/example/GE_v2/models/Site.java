package com.example.GE_v2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "site")
    List<Niveau> niveaux;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Niveau> getNiveaux() {
        return niveaux;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNiveaux(List<Niveau> niveaux) {
        this.niveaux = niveaux;
    }
}
