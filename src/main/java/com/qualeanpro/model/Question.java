package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Question")
    private Long idQuestion;

    @Column(name = "enonce", length = 100)
    private String enonce;

    @Column(name = "bonneReponse", length = 100)
    private String bonneReponse;

    // Relation ManyToOne vers Quiz
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Quiz", nullable = false)
    private Quiz quiz;

    // Constructeurs
    public Question() {}

    public Question(String enonce, String bonneReponse, Quiz quiz) {
        this.enonce = enonce;
        this.bonneReponse = bonneReponse;
        this.quiz = quiz;
    }

    // Getters & Setters
    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
