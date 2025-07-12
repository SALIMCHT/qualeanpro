package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long idQuestion;

    @NotNull(message = "L’énoncé de la question est obligatoire.")
    @Size(min = 50, max = 1000, message = "L’énoncé doit contenir entre 5 et 500 caractères.")
    @Column(name = "enonce", length = 1000, nullable = false)
    private String enonce;

    @NotNull(message = "La bonne réponse est obligatoire.")
    @Size(max = 500, message = "La bonne réponse ne peut pas dépasser 255 caractères.")
    @Column(name = "bonne_reponse", length = 500, nullable = false)
    private String bonneReponse;

    @NotNull(message = "Le quiz associé est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quiz", nullable = false)
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
