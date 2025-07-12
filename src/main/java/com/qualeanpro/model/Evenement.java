package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import com.qualeanpro.model.enums.TypeEvenement;

@Entity
@Table(name = "evenement")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evenement")
    private Long id;

    @NotNull(message = "Le type d'événement est obligatoire.")
    @Enumerated(EnumType.STRING)
    @Column(name = "type_evenement", nullable = false)
    private TypeEvenement typeEvenement;

    @NotNull(message = "La date de l'événement est obligatoire.")
    @CreationTimestamp
    @Column(name = "date_evenement", updatable = false)
    private LocalDateTime dateEvenement;

    @Column(name = "description")
    private String description;

    @NotNull(message = "L'identifiant de la cible est obligatoire.")
    @Column(name = "cible_id", nullable = false)
    private Long cibleId;

    @NotNull(message = "Le type de la cible est obligatoire.")
    @Column(name = "cible_type", nullable = false)
    private String cibleType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acteur_id") // nullable = true par défaut, inutile de le préciser
    private User acteur;

    // ----- Getters and Setters -----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeEvenement getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(TypeEvenement typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public LocalDateTime getDateEvenement() {
        return dateEvenement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCibleId() {
        return cibleId;
    }

    public void setCibleId(Long cibleId) {
        this.cibleId = cibleId;
    }

    public String getCibleType() {
        return cibleType;
    }

    public void setCibleType(String cibleType) {
        this.cibleType = cibleType;
    }

    public User getActeur() {
        return acteur;
    }

    public void setActeur(User acteur) {
        this.acteur = acteur;
    }
}
