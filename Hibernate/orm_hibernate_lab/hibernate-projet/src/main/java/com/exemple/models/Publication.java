package com.exemple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "publication")
public abstract class Publication extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Le titre ne doit pas être nul")
    @Size(max = 200, message = "Le titre ne doit pas dépasser 100 caractères")
    @Column(length = 200, nullable = false)
    private String title;

    @NotNull(message = "Le contenu ne doit pas être nul")
    private String content;

    @NotNull(message = "La date de publication ne doit pas être nulle")
    @PastOrPresent
    private LocalDate datePublication;

    public Publication() {}

    public Publication(String title, String content, LocalDate datePublication) {
        this.title = title;
        this.content = content;
        this.datePublication = datePublication;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public String getContent() {
        return content;
    }
}
