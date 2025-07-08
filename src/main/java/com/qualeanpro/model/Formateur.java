package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Formateur")
public class Formateur extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formateur")
    private Long idFormateur;

    @Column(length = 200)
    private String biographie;

    @Column(length = 200)
    private String competences;

    @Column(length = 100)
    private String cvURL;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User user;

    public Formateur() {}

    public Formateur(String biographie, String competences, String cvURL, User user) {
        this.biographie = biographie;
        this.competences = competences;
        this.cvURL = cvURL;
        this.user = user;
    }

    // Getters et setters

    public Long getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(Long idFormateur) {
        this.idFormateur = idFormateur;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
