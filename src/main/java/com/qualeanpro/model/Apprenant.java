package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Apprenant")
public class Apprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apprenant")
    private Long idApprenant;

    @Column(name = "progression")
    private Double progression;

    @Column(name = "situationprofessionnelle", length = 100)
    private String situationProfessionnelle;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User user;

    // Constructeurs
    public Apprenant() {}

    public Apprenant(Double progression, String situationProfessionnelle, User user) {
        this.progression = progression;
        this.situationProfessionnelle = situationProfessionnelle;
        this.user = user;
    }

    // Getters et setters

    public Long getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(Long idApprenant) {
        this.idApprenant = idApprenant;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
