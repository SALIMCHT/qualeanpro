package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quiz")
    private Long idQuiz;

    @NotNull(message = "Le titre du quiz est obligatoire.")
    @Column(name = "titre_quiz", length = 100, nullable = false)
    private String titreQuiz;

    @NotNull(message = "La durée du quiz est obligatoire.")
    @Column(name = "duree_quiz", nullable = false)
    private BigDecimal dureeQuiz;

    @NotNull(message = "La formation associée est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formation", nullable = false)
    private Formation formation;

    // ✅ Constructeurs

    public Quiz() {}

    public Quiz(String titreQuiz, BigDecimal dureeQuiz, Formation formation) {
        this.titreQuiz = titreQuiz;
        this.dureeQuiz = dureeQuiz;
        this.formation = formation;
    }

    // ✅ Getters & Setters

    public Long getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(Long idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getTitreQuiz() {
        return titreQuiz;
    }

    public void setTitreQuiz(String titreQuiz) {
        this.titreQuiz = titreQuiz;
    }

    public BigDecimal getDureeQuiz() {
        return dureeQuiz;
    }

    public void setDureeQuiz(BigDecimal dureeQuiz) {
        this.dureeQuiz = dureeQuiz;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
