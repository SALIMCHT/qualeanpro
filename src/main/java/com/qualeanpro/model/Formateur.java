package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "formateur")
public class Formateur extends User {

    @Column(length = 200)
    private String biographie;

    @Column(length = 200)
    private String competences;

    @Column(length = 100)
    private String cvURL;

    public Formateur() {}

    public Formateur(String biographie, String competences, String cvURL) {
        this.biographie = biographie;
        this.competences = competences;
        this.cvURL = cvURL;
    }

    // Getters et setters

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getCvURL() {
        return cvURL;
    }

    public void setCvURL(String cvURL) {
        this.cvURL = cvURL;
    }
}
