package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "option_question")
public class OptionQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_option")
    private Long idOption;

    @Column(name = "Libelle", length = 200, nullable = false)
    private String libelle;

    // Relation ManyToOne vers Question
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question", nullable = false)
    private Question question;

    // Constructeurs

    public OptionQuestion() {}

    public OptionQuestion(String libelle, Question question) {
        this.libelle = libelle;
        this.question = question;
    }

    // Getters & Setters

    public Long getIdOption() {
        return idOption;
    }

    public void setIdOption(Long idOption) {
        this.idOption = idOption;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
