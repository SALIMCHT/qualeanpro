package com.qualeanpro.model;

import com.qualeanpro.model.enums.TypeContenu;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Contenus")
public class Contenus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenus")
    private Long idContenus;

    @Column(name = "titre_contenus", length = 100, nullable = false)
    private String titreContenus;

    @Column(name = "description_contenus", length = 500, nullable = false)
    private String descriptionContenus;

    @Column(name = "dureeEstimee", nullable = false)
    private Double dureeEstimee;

    @Enumerated(EnumType.STRING)
    @Column(name = "typeContenu", length = 50, nullable = false)
    private TypeContenu typeContenu;

    @Column(name = "urlContenu", length = 400, nullable = false)
    private String urlContenu;

    @Column(name = "estTelechargable", nullable = false)
    private Boolean estTelechargable;

    @Column(name = "dateAjout", nullable = false)
    private LocalDateTime dateAjout;

    @Column(name = "dateDerniereMaj", nullable = false)
    private LocalDate dateDerniereMaj;

    // 🔗 Relation ManyToOne avec Formation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formation", nullable = false)
    private Formation formation;

    // 🔧 Constructeurs

    public Contenus() {}

    public Contenus(String titreContenus, String descriptionContenus, Double dureeEstimee,
                    TypeContenu typeContenu, String urlContenu, Boolean estTelechargable,
                    LocalDateTime dateAjout, LocalDate dateDerniereMaj, Formation formation) {
        this.titreContenus = titreContenus;
        this.descriptionContenus = descriptionContenus;
        this.dureeEstimee = dureeEstimee;
        this.typeContenu = typeContenu;
        this.urlContenu = urlContenu;
        this.estTelechargable = estTelechargable;
        this.dateAjout = dateAjout;
        this.dateDerniereMaj = dateDerniereMaj;
        this.formation = formation;
    }

    // ✅ Getters & Setters

    public Long getIdContenus() {
        return idContenus;
    }

    public void setIdContenus(Long idContenus) {
        this.idContenus = idContenus;
    }

    public String getTitreContenus() {
        return titreContenus;
    }

    public void setTitreContenus(String titreContenus) {
        this.titreContenus = titreContenus;
    }

    public String getDescriptionContenus() {
        return descriptionContenus;
    }

    public void setDescriptionContenus(String descriptionContenus) {
        this.descriptionContenus = descriptionContenus;
    }

    public Double getDureeEstimee() {
        return dureeEstimee;
    }

    public void setDureeEstimee(Double dureeEstimee) {
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

    public Boolean getEstTelechargable() {
        return estTelechargable;
    }

    public void setEstTelechargable(Boolean estTelechargable) {
        this.estTelechargable = estTelechargable;
    }

    public LocalDateTime getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDateTime dateAjout) {
        this.dateAjout = dateAjout;
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
