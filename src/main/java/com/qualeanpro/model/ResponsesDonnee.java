package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "responses_donnee")
public class ResponsesDonnee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reponse")
    private Long idReponse;

    @Column(name = "valeur_reponse", length = 100)
    private String valeurReponse;

    // Relation ManyToOne vers PassageQuiz
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_PassageQuiz", nullable = false)
    private PassageQuiz passageQuiz;

    // Relation ManyToOne vers Question
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
