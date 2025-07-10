package com.qualeanpro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.qualeanpro.model.enums.StatutFormation;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formation")
    private Long idFormation;

    @Column(name = "titre_formation", length = 200, nullable = false)
    private String titreFormation;

    @Column(name = "description_formation", length = 1000, nullable = false)
    private String descriptionFormation;

    @Column(name = "datecreation", nullable = false)
    private LocalDateTime datecreation;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "langue", length = 100, nullable = false)
    private String langue;

    @Column(name = "nombreinscription", nullable = false)
    private Integer nombreinscription;
    
    
    @Enumerated(EnumType.STRING)
    @Column(name = "statut_formation", length = 50, nullable = false)
    private StatutFormation statutFormation;

    @Column(name = "estpayante", nullable = false)
    private Boolean estpayante;

    @Column(name = "totalheures", nullable = false)
    private Double totalheures;

    @Column(name = "coupon", length = 100)
    private String coupon;

    @Column(name = "pourcentagerevenuformateur", nullable = false)
    private Double pourcentagerevenuformateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formateur")
    private Formateur formateur;

    public Formation() {
    }

    public Formation(String titreFormation, String descriptionFormation, LocalDateTime dateCreation, Double prix,
                     String langue, Integer nombreInscription, StatutFormation statutFormation, Boolean estPayante,
                     Double totalHeures, String coupon, Double pourcentageRevenuFormateur, Formateur formateur) {
        this.titreFormation = titreFormation;
        this.descriptionFormation = descriptionFormation;
        this.datecreation = dateCreation;
        this.prix = prix;
        this.langue = langue;
        this.nombreinscription = nombreInscription;
        this.statutFormation = statutFormation;
        this.estpayante = estPayante;
        this.totalheures = totalHeures;
        this.coupon = coupon;
        this.pourcentagerevenuformateur = pourcentageRevenuFormateur;
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
        return datecreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.datecreation = dateCreation;
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
        return nombreinscription;
    }

    public void setNombreInscription(Integer nombreInscription) {
        this.nombreinscription = nombreInscription;
    }

    public StatutFormation getStatutFormation() {
        return statutFormation;
    }

    public void setStatutFormation(StatutFormation statutFormation) {
        this.statutFormation = statutFormation;
    }

    public Boolean getEstPayante() {
        return estpayante;
    }

    public void setEstPayante(Boolean estPayante) {
        this.estpayante = estPayante;
    }

    public Double getTotalHeures() {
        return totalheures;
    }

    public void setTotalHeures(Double totalHeures) {
        this.totalheures = totalHeures;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Double getPourcentageRevenuFormateur() {
        return pourcentagerevenuformateur;
    }

    public void setPourcentageRevenuFormateur(Double pourcentageRevenuFormateur) {
        this.pourcentagerevenuformateur = pourcentageRevenuFormateur;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }
}

