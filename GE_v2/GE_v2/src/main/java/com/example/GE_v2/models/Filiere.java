package com.example.GE_v2.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFiliere;
    private String nom;

    //Niveau
    @ManyToOne
    @JoinColumn(name = "idNiveau")
    private Niveau niveau;

    //Eleve
    @OneToMany(mappedBy = "filiere")
    List<Eleve> eleves;

    public Filiere() {

    }

    public Long getIdFiliere() {
        return idFiliere;
    }

    public String getNom() {
        return nom;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public Filiere(String nom, Niveau niveau, List<Eleve> eleves) {
        this.nom = nom;
        this.niveau = niveau;
        this.eleves = eleves;
    }

    public void setIdFiliere(Long idFiliere) {
        this.idFiliere = idFiliere;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
}
