package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur extends User {

    // Ajoute ici les champs spécifiques à l'administrateur, s'il y en a
    // Par exemple :
    @Column(name = "responsabilite", length = 100)
    private String responsabilite;

    // Constructeurs
    public Administrateur() {}

    public Administrateur(String responsabilite) {
        this.responsabilite = responsabilite;
    }

    // Getters & setters

    public String getResponsabilite() {
        return responsabilite;
    }

    public void setResponsabilite(String responsabilite) {
        this.responsabilite = responsabilite;
    }
}
