package com.qualeanpro.model;

import com.qualeanpro.model.enums.StatutPaiement;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Paiement")
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paiement")
    private Long idPaiement;

    @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "datePaiement", nullable = false)
    private LocalDateTime datePaiement;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_Paiement", nullable = false, length = 50)
    private StatutPaiement statutPaiement;

    // ✅ Clé étrangère vers Apprenant
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apprenant", nullable = false)
    private Apprenant apprenant;

    // ✅ Clé étrangère vers Formation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formation", nullable = false)
    private Formation formation;

    // Constructeurs

    public Paiement() {}

    public Paiement(Double montant, LocalDateTime datePaiement, StatutPaiement statutPaiement,
                    Apprenant apprenant, Formation formation) {
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.statutPaiement = statutPaiement;
        this.apprenant = apprenant;
        this.formation = formation;
    }

    // Getters & Setters

    public Long getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(Long idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public StatutPaiement getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(StatutPaiement statutPaiement) {
        this.statutPaiement = statutPaiement;
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
