package com.qualeanpro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "option_question")
public class OptionQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_option")
    private Long idOption;

    @NotNull(message = "Le libellé de l'option est obligatoire.")
    @Size(max = 1000, message = "Le libellé ne peut pas dépasser 200 caractères.")
    @Column(name = "libelle", length = 1000, nullable = false)
    private String libelle;

    // Relation ManyToOne vers Question
    @NotNull(message = "La question associée est obligatoire.")
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
