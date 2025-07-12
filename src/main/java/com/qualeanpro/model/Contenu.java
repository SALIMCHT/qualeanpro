package com.qualeanpro.model;

import com.qualeanpro.model.enums.TypeContenu;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contenus") // convention snake_case pour les tables
public class Contenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenu")
    private Long idContenu;

    @NotNull(message = "Le titre du contenu est obligatoire.")
    @Column(name = "titre_contenu", length = 100, nullable = false)
    private String titreContenu;

    @NotNull(message = "La description du contenu est obligatoire.")
    @Column(name = "description_contenu", length = 500, nullable = false)
    private String descriptionContenu;

    @NotNull(message = "La durée estimée est obligatoire.")
    @Column(name = "duree_estimee", nullable = false)
    private BigDecimal dureeEstimee;

    @NotNull(message = "Le type de contenu est obligatoire.")
    @Enumerated(EnumType.STRING)
    @Column(name = "type_contenu", length = 50, nullable = false)
    private TypeContenu typeContenu;

    @NotNull(message = "L'URL du contenu est obligatoire.")
    @Column(name = "url_contenu", length = 400, nullable = false)
    private String urlContenu;

    @NotNull(message = "Le champ 'estTéléchargeable' est obligatoire.")
    @Column(name = "est_telechargeable", nullable = false)
    private Boolean estTelechargeable;

    @CreationTimestamp
    @Column(name = "date_ajout", nullable = false, updatable = false)
    private LocalDateTime dateAjout;

    @NotNull(message = "La date de dernière mise à jour est obligatoire.")
    @Column(name = "date_derniere_maj", nullable = false)
    private LocalDate dateDerniereMaj;

    @NotNull(message = "La formation liée est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formation", nullable = false)
    private Formation formation;

    // ----- Constructeurs -----

    public Contenu() {}

    public Contenu(String titreContenu, String descriptionContenu, BigDecimal dureeEstimee,
                   TypeContenu typeContenu, String urlContenu, Boolean estTelechargeable,
                   LocalDate dateDerniereMaj, Formation formation) {
        this.titreContenu = titreContenu;
        this.descriptionContenu = descriptionContenu;
        this.dureeEstimee = dureeEstimee;
        this.typeContenu = typeContenu;
        this.urlContenu = urlContenu;
        this.estTelechargeable = estTelechargeable;
        this.dateDerniereMaj = dateDerniereMaj;
        this.formation = formation;
    }

    // ----- Getters & Setters -----

    public Long getIdContenu() {
        return idContenu;
    }

    public void setIdContenu(Long idContenu) {
        this.idContenu = idContenu;
    }

    public String getTitreContenu() {
        return titreContenu;
    }

    public void setTitreContenu(String titreContenu) {
        this.titreContenu = titreContenu;
    }

    public String getDescriptionContenu() {
        return descriptionContenu;
    }

    public void setDescriptionContenu(String descriptionContenu) {
        this.descriptionContenu = descriptionContenu;
    }

    public BigDecimal getDureeEstimee() {
        return dureeEstimee;
    }

    public void setDureeEstimee(BigDecimal dureeEstimee) {
        this.dureeEstimee = dureeEstimee;
    }

    public TypeContenu getTypeContenu() {
        return typeContenu;
    }

    public void setTypeContenu(TypeContenu typeContenu) {
        this.typeContenu = typeContenu;
    }

    public String getUrlContenu() {
        return urlContenu;
    }

    public void setUrlContenu(String urlContenu) {
        this.urlContenu = urlContenu;
    }

    public Boolean getEstTelechargeable() {
        return estTelechargeable;
    }

    public void setEstTelechargeable(Boolean estTelechargeable) {
        this.estTelechargeable = estTelechargeable;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public LocalDate getDateDerniereMaj() {
        return dateDerniereMaj;
    }

    public void setDateDerniereMaj(LocalDate dateDerniereMaj) {
        this.dateDerniereMaj = dateDerniereMaj;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
