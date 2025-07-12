package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "passage_quiz")
public class PassageQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passage_quiz")
    private Long idPassageQuiz;

    @NotNull(message = "La date de passage est obligatoire.")
    @CreationTimestamp
    @Column(name = "date_passage", nullable = false, updatable = false)
    private LocalDateTime datePassage;

    @NotNull(message = "Le score obtenu est obligatoire.")
    @Column(name = "scoreobtenue", nullable = false)
    private Double scoreObtenu;

    @NotNull(message = "Le statut du passage est obligatoire.")
    @Column(name = "statut_passagequiz", nullable = false)
    private Boolean statutPassageQuiz;

    @NotNull(message = "L'apprenant est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_apprenant", nullable = false)
    private Apprenant apprenant;

    @NotNull(message = "Le quiz associé est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quiz", nullable = false)
    private Quiz quiz;

    // Constructeurs

    public PassageQuiz() {}

    public PassageQuiz(Double scoreObtenu, Boolean statutPassageQuiz, Apprenant apprenant, Quiz quiz) {
        this.scoreObtenu = scoreObtenu;
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

    public Double getScoreObtenu() {
        return scoreObtenu;
    }

    public void setScoreObtenu(Double scoreObtenu) {
        this.scoreObtenu = scoreObtenu;
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
