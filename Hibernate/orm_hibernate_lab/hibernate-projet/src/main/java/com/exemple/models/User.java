package com.exemple.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "user")
public class User extends GenericEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String email;

    @OneToMany(targetEntity = Article.class, mappedBy = "author")
    private List<Publication> publications;
    // 1 utilisateur possède plusieurs articles

    public User() {
        publications = new ArrayList<>();
    }

    public User(String nom) {
        this();
        this.nom = nom;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPublications(List<Publication> articles) {
        this.publications = articles;
    }


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public List<Publication> getPublications() {
        return publications;
    }


    public void print() {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("ID", getId().toString());
        attributes.put("nom", getNom());
        attributes.put("email", getEmail());
        print(attributes);
    }
}
