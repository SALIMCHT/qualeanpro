package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.qualeanpro.model.enums.Genre;
import com.qualeanpro.model.enums.Role;

@Entity
@Table(name = "apprenant")
public class Apprenant extends User {

    @Column(name = "progression", nullable = false)
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private Double progression;

    @Column(name = "situationprofessionnelle", length = 100, nullable = false)
    @NotBlank(message = "La situation professionnelle est obligatoire")
    private String situationProfessionnelle;

    // Constructeur par défaut
    public Apprenant() {
        setRole(Role.APPRENANT);
    }

    // Constructeur avec champs spécifiques
    public Apprenant(Double progression, String situationProfessionnelle) {
        this.progression = progression;
        this.situationProfessionnelle = situationProfessionnelle;
        setRole(Role.APPRENANT);
    }

    // Constructeur complet avec champs hérités
    public Apprenant(String nom, String prenom, String email, String adresse, String telephone,
                     String motDePasse, String photoProfile, LocalDateTime dateInscription,
                     LocalDate dateNaissance, String ville, String cine, Genre genre,
                     Double progression, String situationProfessionnelle) {

        super(nom, prenom, email, adresse, telephone, motDePasse, photoProfile,
              dateInscription, dateNaissance, ville, cine, genre ,Role.APPRENANT);

        this.progression = progression;
        this.situationProfessionnelle = situationProfessionnelle;
    }

    // Getters et Setters
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
