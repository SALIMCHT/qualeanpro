package com.qualeanpro.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Certificat")
public class Certificat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_certificat")
    private Long idCertificat;

    @Column(name = "numeroCertificat", length = 100, nullable = false)
    private String numeroCertificat;

    @Column(name = "dateParticipation", nullable = false)
    private LocalDate dateParticipation;

    @Column(name = "dureeFormation", nullable = false)
    private Double dureeFormation;

    @Column(name = "organisation", length = 100)
    private String organisation;

    @Column(name = "typeForamtion", length = 100)
    private String typeForamtion;

    @Column(name = "objectif", length = 100)
    private String objectif;

    @Column(name = "partage", nullable = false)
    private Boolean partage;

    @Column(name = "contents", length = 200)
    private String contents;

    // 🔗 Relation ManyToOne avec Apprenant
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apprenant", nullable = false)
    private Apprenant apprenant;

    // ✅ Constructeurs

    public Certificat() {}

    public Certificat(String numeroCertificat, LocalDate dateParticipation, Double dureeFormation,
                      String organisation, String typeForamtion, String objectif, Boolean partage,
                      String contents, Apprenant apprenant) {
        this.numeroCertificat = numeroCertificat;
        this.dateParticipation = dateParticipation;
        this.dureeFormation = dureeFormation;
        this.organisation = organisation;
        this.typeForamtion = typeForamtion;
        this.objectif = objectif;
        this.partage = partage;
        this.contents = contents;
        this.apprenant = apprenant;
    }

    // ✅ Getters & Setters

    public Long getIdCertificat() {
        return idCertificat;
    }

    public void setIdCertificat(Long idCertificat) {
        this.idCertificat = idCertificat;
    }

    public String getNumeroCertificat() {
        return numeroCertificat;
    }

    public void setNumeroCertificat(String numeroCertificat) {
        this.numeroCertificat = numeroCertificat;
    }

    public LocalDate getDateParticipation() {
        return dateParticipation;
    }

    public void setDateParticipation(LocalDate dateParticipation) {
        this.dateParticipation = dateParticipation;
    }

    public Double getDureeFormation() {
        return dureeFormation;
    }

    public void setDureeFormation(Double dureeFormation) {
        this.dureeFormation = dureeFormation;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getTypeForamtion() {
        return typeForamtion;
    }

    public void setTypeForamtion(String typeForamtion) {
        this.typeForamtion = typeForamtion;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public Boolean getPartage() {
        return partage;
    }

    public void setPartage(Boolean partage) {
        this.partage = partage;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
}
