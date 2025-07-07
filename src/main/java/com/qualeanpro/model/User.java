package com.qualeanpro.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
//Stratégie héritage avec jointure
@Inheritance(strategy = InheritanceType.JOINED)  
@Table(name = "utilisateur")
public abstract class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "adresse", length = 100)
    private String adresse;

    @Column(name = "telephone", length = 15)
    private String telephone;

    @Column(name = "motdepasse", nullable = false, length = 20)
    private String motDePasse;

    @Column(name = "photoprofile", length = 100)
    private String photoProfile;

    @Column(name = "dateinscription")
    private LocalDateTime dateInscription;

    @Column(name = "datenaissance")
    private LocalDate dateNaissance;

    @Column(name = "ville", length = 50)
    private String ville;

    @Column(name = "cine", length = 10)
    private String cine;

    // Constructeurs

    public User() {}

    public User(String nom, String prenom, String email, String adresse, String telephone, String motDePasse,
                String photoProfile, LocalDateTime dateInscription, LocalDate dateNaissance,
                String ville, String cine) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.photoProfile = photoProfile;
        this.dateInscription = dateInscription;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.cine = cine;
    }

    // Getters & setters

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCine() {
        return cine;
    }

    public void setCine(String cine) {
        this.cine = cine;
    }
}
