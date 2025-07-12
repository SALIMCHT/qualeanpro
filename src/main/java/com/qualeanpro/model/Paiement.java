package com.qualeanpro.model;

import com.qualeanpro.model.enums.StatutPaiement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "paiement")
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paiement")
    private Long idPaiement;

    @NotNull(message="Le montant du paiement est obligatoire.")
    @Positive
    @Column(name = "montant", nullable = false)
    private Double montant;

    @CreationTimestamp
    @Column(name = "datepaiement", nullable = false, updatable = false)
    private LocalDateTime datePaiement;

    @NotNull(message = "Le statut du paiement est obligatoire.")
    @Enumerated(EnumType.STRING)
    @Column(name = "statut_paiement", nullable = false, length = 50)
    private StatutPaiement statutPaiement;

    // ✅ Clé étrangère vers Apprenant
    @NotNull(message = "L'apprenant est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apprenant", nullable = false)
    private Apprenant apprenant;

    // ✅ Clé étrangère vers Formation
    @NotNull(message = "La formation est obligatoire.")
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
