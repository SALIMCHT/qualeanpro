package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.qualeanpro.model.enums.Genre;
import com.qualeanpro.model.enums.Role;

@Entity
@Table(name = "formateur")
public class Formateur extends User {

    @Column(length = 200)
    @Size(max = 200, message = "La biographie ne doit pas dépasser 200 caractères")
    private String biographie;

    @Column(length = 200)
    @Size(max = 200, message = "Les compétences ne doivent pas dépasser 200 caractères")
    private String competences;

    @Column(length = 100)
    @Size(max = 100, message = "L'URL du CV ne doit pas dépasser 100 caractères")
    private String cvURL;

    // Constructeur par défaut
    public Formateur() {
        setRole(Role.FORMATEUR);
    }

    // Constructeur spécifique
    public Formateur(String biographie, String competences, String cvURL) {
        this.biographie = biographie;
        this.competences = competences;
        this.cvURL = cvURL;
        setRole(Role.FORMATEUR);
    }

    // Constructeur complet avec héritage
    public Formateur(String nom, String prenom, String email, String adresse, String telephone,
                     String motDePasse, String photoProfile, LocalDateTime dateInscription,
                     LocalDate dateNaissance, String ville, String cine, Genre genre,
                     String biographie, String competences, String cvURL) {

        super(nom, prenom, email, adresse, telephone, motDePasse, photoProfile,
              dateInscription, dateNaissance, ville, cine, genre, Role.FORMATEUR);

        this.biographie = biographie;
        this.competences = competences;
        this.cvURL = cvURL;
    }

    // Getters et Setters

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
