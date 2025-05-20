package com.exemple.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("ARTICLE")
public class Article extends Publication {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    // Plusieurs articles partagent 1 auteur

    private Long nbVues;

    public Article() {
        super();
        nbVues = 0L;
    }

    public Article(String title, String content, LocalDate datePublication, User author) {
        super(title,content,datePublication);
        this.author = author;
        nbVues = 0L;
    }
    public Article(String title, String content, LocalDate datePublication, User author, Long nbVues) {
        super(title,content,datePublication);
        this.author = author;
        this.nbVues = nbVues;
    }


    public void setAuthor(User author) {
        this.author = author;
    }

    public void setNbVues(Long nbVues) {
        this.nbVues = nbVues;
    }

    public User getAuthor() {
        return author;
    }

    public Long getNbVues() {
        return nbVues;
    }

    public void print() {
        Map<String,String> attributes = new HashMap<>();
        attributes.put("ID", getId().toString());
        attributes.put("title",getTitle());
        attributes.put("content", getContent());
        if (author != null) {
            attributes.put("author_id", getAuthor().getId().toString());
        } else {
            attributes.put("author_id", "");
        }
        attributes.put("nbVues", String.valueOf(getNbVues()));

        print(attributes);
    }

}
