package com.qualeanpro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qualeanpro.model.enums.Genre;
import com.qualeanpro.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "utilisateur")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    
    // nom doit obligatoirement supérieur à 2 charactéres  
    @JsonProperty("nom")
    @Column(name = "nom", length = 50 , nullable = false)
    @NotNull(message = "Nom est obligatoire !")
    @Size(min = 2, max = 50, message = "Nom doit avoir entre 2 et 50 caractères")
    private String nom;
    
    // prenom doit obligatoirement supérieur à 2 charactéres  
    @JsonProperty("prenom")
    @Column(name = "prenom", length = 50 , nullable = false)
    @NotNull(message = "Prénom est obligatoire !")
    @Size(min = 2, max = 50 , message = "Prénom doit avoir entre 2 et 50 caractères")
    private String prenom;
    
    // email doit obligatoirement avoir @ 
    @JsonProperty("email")
    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Format de l'email est invalide")
    @NotNull(message = "Email est obligatoire")
    private String email;

    @Column(name = "adresse", length = 100)
    private String adresse;
    
    // telephone doit obligatoirement commencer par 05, 06, 07 et 10 chiffres 
    @JsonProperty("telephone")
    @Column(name = "telephone", length = 15 , nullable = false)
    @NotNull(message = "Téléphone est obligatoire !")
    @Pattern(regexp = "^(05|06|07)[0-9]{8}$",message = "Le numéro de téléphone doit commencer par 05, 06, ou 07 et avoir exactement 10 chiffres.")
    private String telephone;

    // motDePasse doit au minimum 8 caractères, majuscules , minuscules, chiffre , caractére spécial 
    @JsonProperty("motDePasse") // correspond à "password" dans le JSON
    @Column(name = "motDePasse", nullable = false, length = 60)
    @NotNull(message = "Mot de passe est obligatoire !")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{8,}$",message = "Mot de passe doit contenir au minimum 8 caractères, dont au moins une majuscule, une minuscule, un chiffre et un caractère spécial.")
    private String motDePasse;

    @Column(name = "photoprofile", length = 100)
    private String photoProfile;

    @Column(name = "dateinscription")
    private LocalDateTime dateinscription;

    @NotNull(message = "La date de naissance ne peut pas être nulle.")  // Valide que la date n'est pas nulle
    @Past(message = "La date de naissance doit être dans le passé.")  // Valide que la date est dans le passé
    @Age(min = 18, max = 60, message = "L'âge doit être entre 18 et 60 ans") // AgeValidator & Age
    @Column(name = "datenaissance")
    private LocalDate dateNaissance;

    @Column(name = "ville", length = 50)
    private String ville;

    @Column(name = "cine", length = 10 , nullable = false)
    private String cine;
    
    @JsonProperty("genre")
    @Enumerated(EnumType.STRING)
    @Column(name = "genre", length = 50 , nullable = false)
    private Genre genre;
    
    @JsonProperty("role")
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private Role role;

    // Initialiser automatiquement la date d'inscription
    @PrePersist
    protected void onCreate() {
        if (dateinscription == null) {
        	dateinscription = LocalDateTime.now();
        }
    }

    // Constructeurs 

    public User() {}

    public User(String nom, String prenom, String email, String adresse, String telephone,
                String motDePasse, String photoProfile, LocalDateTime dateinscription,
                LocalDate dateNaissance, String ville, String cine, Genre genre, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.photoProfile = photoProfile;
        this.dateinscription = dateinscription;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.cine = cine;
        this.genre = genre;
        this.role = role;
    }

    // Getters et Setters 

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
        return dateinscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateinscription = dateInscription;
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

    
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
