package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "responses_donnee")
public class ResponsesDonnee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reponse")
    private Long idReponse;

    @NotNull(message = "La valeur de la réponse est obligatoire.")
    @Size(max = 1000, message = "La valeur de la réponse ne peut dépasser 100 caractères.")
    @Column(name = "valeur_reponse", length = 1000, nullable = false)
    private String valeurReponse;

    @NotNull(message = "Le passage quiz est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_passage_quiz", nullable = false)
    private PassageQuiz passageQuiz;

    @NotNull(message = "La question est obligatoire.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question", nullable = false)
    private Question question;

    // Constructeurs

    public ResponsesDonnee() {}

    public ResponsesDonnee(String valeurReponse, PassageQuiz passageQuiz, Question question) {
        this.valeurReponse = valeurReponse;
        this.passageQuiz = passageQuiz;
        this.question = question;
    }

    // Getters & Setters

    public Long getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Long idReponse) {
        this.idReponse = idReponse;
    }

    public String getValeurReponse() {
        return valeurReponse;
    }

    public void setValeurReponse(String valeurReponse) {
        this.valeurReponse = valeurReponse;
    }

    public PassageQuiz getPassageQuiz() {
        return passageQuiz;
    }

    public void setPassageQuiz(PassageQuiz passageQuiz) {
        this.passageQuiz = passageQuiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}