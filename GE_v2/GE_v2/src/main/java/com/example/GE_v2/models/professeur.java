package com.example.GE_v2.models;


import jakarta.persistence.*;

@Entity
public class professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesseur;
    private String nom;
    private String prenom;
    private String filiere;

    private double salaire;
    @ManyToOne
    @JoinColumn(name = "id")
    private matiere matiere;


    public void setIdProfesseur(Long idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public void setMatiere(com.example.GE_v2.models.matiere matiere) {
        this.matiere = matiere;
    }

    public Long getIdProfesseur() {
        return idProfesseur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getFiliere() {
        return filiere;
    }

    public double getSalaire() {
        return salaire;
    }

    public com.example.GE_v2.models.matiere getMatiere() {
        return matiere;
    }



    public professeur(String nom, String prenom, String filiere, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "professeur{" +
                "idProfesseur=" + idProfesseur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", filiere='" + filiere + '\'' +
                ", salaire=" + salaire +
                '}';
    }

    public professeur() {
    }


    public professeur(String nom, String prenom, String filiere, double salaire, com.example.GE_v2.models.matiere matiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.salaire = salaire;
        this.matiere = matiere;
    }





    public Long getMatiereId() {
        if (matiere != null) {
            return matiere.getId();
        }
        return null;
    }
}

