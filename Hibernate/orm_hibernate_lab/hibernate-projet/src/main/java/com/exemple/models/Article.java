package com.exemple.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "article")
public class Article extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le titre ne doit pas être nul")
    @Size(max = 100, message = "Le titre ne doit pas dépasser 100 caractères")
    @Column(length = 100, nullable = false)
    private String title;

    @NotNull(message = "Le contenu ne doit pas être nul")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    // Plusieurs articles partagent 1 auteur

    public Article() {}

    public Article(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }


    public void print() {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("ID", getId().toString());
        attributes.put("title",getTitle());
        attributes.put("content", getContent());
        print(attributes);
    }

}
