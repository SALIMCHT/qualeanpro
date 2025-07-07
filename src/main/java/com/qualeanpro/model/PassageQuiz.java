package com.qualeanpro.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PassageQuiz")
public class PassageQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_PassageQuiz")
    private Long idPassageQuiz;

    @Column(name = "date_passage", nullable = false)
    private LocalDateTime datePassage;

    @Column(name = "scoreObtenue", nullable = false)
    private Double scoreObtenue;

    @Column(name = "statut_passageQuiz", nullable = false)
    private Boolean statutPassageQuiz;

    // Relation ManyToOne vers Apprenant
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Apprenant", nullable = false)
    private Apprenant apprenant;

    // Relation ManyToOne vers Quiz
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Quiz", nullable = false)
    private Quiz quiz;

    // Constructeurs
    public PassageQuiz() {}

    public PassageQuiz(LocalDateTime datePassage, Double scoreObtenue, Boolean statutPassageQuiz,
                      Apprenant apprenant, Quiz quiz) {
        this.datePassage = datePassage;
        this.scoreObtenue = scoreObtenue;
        this.statutPassageQuiz = statutPassageQuiz;
        this.apprenant = apprenant;
        this.quiz = quiz;
    }

    // Getters & Setters

    public Long getIdPassageQuiz() {
        return idPassageQuiz;
    }

    public void setIdPassageQuiz(Long idPassageQuiz) {
        this.idPassageQuiz = idPassageQuiz;
    }

    public LocalDateTime getDatePassage() {
        return datePassage;
    }

    public void setDatePassage(LocalDateTime datePassage) {
        this.datePassage = datePassage;
    }

    public Double getScoreObtenue() {
        return scoreObtenue;
    }

    public void setScoreObtenue(Double scoreObtenue) {
        this.scoreObtenue = scoreObtenue;
    }

    public Boolean getStatutPassageQuiz() {
        return statutPassageQuiz;
    }

    public void setStatutPassageQuiz(Boolean statutPassageQuiz) {
        this.statutPassageQuiz = statutPassageQuiz;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
