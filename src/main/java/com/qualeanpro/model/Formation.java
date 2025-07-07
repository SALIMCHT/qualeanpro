package com.qualeanpro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formation")
    private Long idFormation;

    @Column(name = "titre_formation", length = 200, nullable = false)
    private String titreFormation;

    @Column(name = "description_formation", length = 1000, nullable = false)
    private String descriptionFormation;

    @Column(name = "dateCreation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "langue", length = 100, nullable = false)
    private String langue;

    @Column(name = "nombreInscription", nullable = false)
    private Integer nombreInscription;

    @Column(name = "statut_formation", length = 50, nullable = false)
    private String statutFormation;

    @Column(name = "estPayante", nullable = false)
    private Boolean estPayante;

    @Column(name = "totalheures", nullable = false)
    private Double totalHeures;

    @Column(name = "coupon", length = 100)
    private String coupon;

    @Column(name = "pourcentageRevenuFormateur", nullable = false)
    private Double pourcentageRevenuFormateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formateur")
    private Formateur formateur;

    public Formation() {
    }

    public Formation(String titreFormation, String descriptionFormation, LocalDateTime dateCreation, Double prix,
                     String langue, Integer nombreInscription, String statutFormation, Boolean estPayante,
                     Double totalHeures, String coupon, Double pourcentageRevenuFormateur, Formateur formateur) {
        this.titreFormation = titreFormation;
        this.descriptionFormation = descriptionFormation;
        this.dateCreation = dateCreation;
        this.prix = prix;
        this.langue = langue;
        this.nombreInscription = nombreInscription;
        this.statutFormation = statutFormation;
        this.estPayante = estPayante;
        this.totalHeures = totalHeures;
        this.coupon = coupon;
        this.pourcentageRevenuFormateur = pourcentageRevenuFormateur;
        this.formateur = formateur;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(Long idFormation) {
        this.idFormation = idFormation;
    }

    public String getTitreFormation() {
        return titreFormation;
    }

    public void setTitreFormation(String titreFormation) {
        this.titreFormation = titreFormation;
    }

    public String getDescriptionFormation() {
        return descriptionFormation;
    }

    public void setDescriptionFormation(String descriptionFormation) {
        this.descriptionFormation = descriptionFormation;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Integer getNombreInscription() {
        return nombreInscription;
    }

    public void setNombreInscription(Integer nombreInscription) {
        this.nombreInscription = nombreInscription;
    }

    public String getStatutFormation() {
        return statutFormation;
    }

    public void setStatutFormation(String statutFormation) {
        this.statutFormation = statutFormation;
    }

    public Boolean getEstPayante() {
        return estPayante;
    }

    public void setEstPayante(Boolean estPayante) {
        this.estPayante = estPayante;
    }

    public Double getTotalHeures() {
        return totalHeures;
    }

    public void setTotalHeures(Double totalHeures) {
        this.totalHeures = totalHeures;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Double getPourcentageRevenuFormateur() {
        return pourcentageRevenuFormateur;
    }

    public void setPourcentageRevenuFormateur(Double pourcentageRevenuFormateur) {
        this.pourcentageRevenuFormateur = pourcentageRevenuFormateur;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }
}

