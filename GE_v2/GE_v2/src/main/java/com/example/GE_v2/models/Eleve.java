package com.example.GE_v2.models;

import jakarta.persistence.*;

@Entity
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEleve;
    private String nom;

    //Filiere
    @ManyToOne
    @JoinColumn(name = "idFiliere")
    private Filiere filiere;

    public Long getIdEleve() {
        return idEleve;
    }

    public String getNom() {
        return nom;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
