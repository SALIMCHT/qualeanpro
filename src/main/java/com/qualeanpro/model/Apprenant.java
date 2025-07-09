package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apprenant")
public class Apprenant extends User {

    @Column(name = "progression")
    private Double progression;

    @Column(name = "situationprofessionnelle", length = 100)
    private String situationProfessionnelle;

    // Constructeurs
    public Apprenant() {}

    public Apprenant(Double progression, String situationProfessionnelle) {
        this.progression = progression;
        this.situationProfessionnelle = situationProfessionnelle;
    }

    // Getters et setters

    public Double getProgression() {
        return progression;
    }

    public void setProgression(Double progression) {
        this.progression = progression;
    }

    public String getSituationProfessionnelle() {
        return situationProfessionnelle;
    }

    public void setSituationProfessionnelle(String situationProfessionnelle) {
        this.situationProfessionnelle = situationProfessionnelle;
    }
}
