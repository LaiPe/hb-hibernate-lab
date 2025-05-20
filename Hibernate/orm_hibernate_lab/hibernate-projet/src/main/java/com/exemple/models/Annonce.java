package com.exemple.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("ANNONCE")
public class Annonce extends Publication {

    @NotNull
    private LocalDate dateExpiration;

    @NotBlank
    @Email
    private String contactEmail;

    private BigDecimal prix;

    public Annonce() {
        super();
        prix = BigDecimal.ZERO;
    }

    public Annonce(String title, String content, LocalDate datePublication, LocalDate dateExpiration, String contactEmail) {
        super(title, content, datePublication);
        this.dateExpiration = dateExpiration;
        this.contactEmail = contactEmail;
        prix = BigDecimal.ZERO;
    }

    public Annonce(String title, String content, LocalDate datePublication, LocalDate dateExpiration, String contactEmail, BigDecimal prix) {
        super(title, content, datePublication);
        this.dateExpiration = dateExpiration;
        this.contactEmail = contactEmail;
        this.prix = prix;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        if (dateExpiration.isAfter(getDatePublication())) {
            this.dateExpiration = dateExpiration;
        } else {
            throw new IllegalArgumentException("The expiration date cannot be before the publication date");
        }
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }
    public String getContactEmail() {
        return contactEmail;
    }
    public BigDecimal getPrix() {
        return prix;
    }

    public void print() {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("ID", getId().toString());
        attributes.put("title",getTitle());
        attributes.put("content", getContent());
        attributes.put("date_expiration",getDateExpiration().toString());
        attributes.put("contact_email",getContactEmail());
        attributes.put("prix",getPrix().toString());

        print(attributes);
    }
}
