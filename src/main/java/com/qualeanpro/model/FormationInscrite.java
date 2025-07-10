package com.qualeanpro.model;

import com.qualeanpro.model.enums.StatutFormation;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "formationinscrite", uniqueConstraints = {
    @UniqueConstraint(columnNames = { "id_apprenant", "id_formation" })
})
public class FormationInscrite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_formation_inscrite")
    private Long idFormationInscrite;

    @Column(name = "date_inscription", nullable = false)
    private LocalDateTime dateInscription;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_formationinscrite", length = 50, nullable = false)
    private StatutFormation statutFormationInscrite;

    @Column(name = "progression", nullable = false)
    private Double progression;

    @Column(name = "certificat_obtenu", nullable = false)
    private Boolean certificatObtenu;

    @Column(name = "feedback", length = 200, nullable = false)
    private String feedback;

    @Column(name = "note_feedback", nullable = false)
    private Integer noteFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apprenant", nullable = false)
    private Apprenant apprenant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formation", nullable = false)
    private Formation formation;

    // Constructeurs

    public FormationInscrite() {}

    public FormationInscrite(LocalDateTime dateInscription, LocalDate dateFin, StatutFormation statutFormationInscrite,
                             Double progression, Boolean certificatObtenu, String feedback, Integer noteFeedback,
                             Apprenant apprenant, Formation formation) {
        this.dateInscription = dateInscription;
        this.dateFin = dateFin;
        this.statutFormationInscrite = statutFormationInscrite;
        this.progression = progression;
        this.certificatObtenu = certificatObtenu;
        this.feedback = feedback;
        this.noteFeedback = noteFeedback;
        this.apprenant = apprenant;
        this.formation = formation;
    }

    // Getters & Setters

    public Long getIdFormationInscrite() {
        return idFormationInscrite;
    }

    public void setIdFormationInscrite(Long idFormationInscrite) {
        this.idFormationInscrite = idFormationInscrite;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public StatutFormation getStatutFormationInscrite() {
        return statutFormationInscrite;
    }

    public void setStatutFormationInscrite(StatutFormation statutFormationInscrite) {
        this.statutFormationInscrite = statutFormationInscrite;
    }

    public Double getProgression() {
        return progression;
    }

    public void setProgression(Double progression) {
        this.progression = progression;
    }

    public Boolean getCertificatObtenu() {
        return certificatObtenu;
    }

    public void setCertificatObtenu(Boolean certificatObtenu) {
        this.certificatObtenu = certificatObtenu;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getNoteFeedback() {
        return noteFeedback;
    }

    public void setNoteFeedback(Integer noteFeedback) {
        this.noteFeedback = noteFeedback;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
