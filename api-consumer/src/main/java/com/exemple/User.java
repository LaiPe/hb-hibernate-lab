package com.exemple;

public class User {

    private Long id;

    private String nom;

    private String email;

    public User() {

    }

    public User(String nom, String email) {
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


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }
}
