package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private Long id;

    @NotNull(message = "Le message de notification est obligatoire.")
    @Column(name = "message", nullable = false)
    private String message;

    @CreationTimestamp
    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation;

    @NotNull(message = "Le statut de lecture doit être défini.")
    @Column(name = "est_lue", nullable = false)
    private Boolean estLue = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evenement", nullable = false)
    private Evenement evenement;

    @NotNull(message = "L'utilisateur destinataire est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    private User utilisateur;

    // ----- Constructeurs -----

    public Notification() {}

    public Notification(String message, Boolean estLue, Evenement evenement, User utilisateur) {
        this.message = message;
        this.estLue = estLue;
        this.evenement = evenement;
        this.utilisateur = utilisateur;
    }

    // ----- Getters and Setters -----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public Boolean getEstLue() {
        return estLue;
    }

    public void setEstLue(Boolean estLue) {
        this.estLue = estLue;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }
}
