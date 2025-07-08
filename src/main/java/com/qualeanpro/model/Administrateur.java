package com.qualeanpro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Administrateur")
public class Administrateur extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrateur")
    private Long idAdministrateur;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User user;

    // Constructeurs
    public Administrateur() {}

    public Administrateur(User user) {
        this.user = user;
    }

    // Getters & setters

    public Long getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(Long idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
