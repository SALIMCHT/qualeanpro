package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Quiz")
    private Long idQuiz;

    @Column(name = "titre_Quiz", length = 100, nullable = false)
    private String titreQuiz;

    @Column(name = "duree_Quiz", nullable = false)
    private Double dureeQuiz;

    // 🔗 Relation ManyToOne avec Formation
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formation", nullable = false)
    private Formation formation;

    // ✅ Constructeurs

    public Quiz() {}

    public Quiz(String titreQuiz, Double dureeQuiz, Formation formation) {
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

    public Double getDureeQuiz() {
        return dureeQuiz;
    }

    public void setDureeQuiz(Double dureeQuiz) {
        this.dureeQuiz = dureeQuiz;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
