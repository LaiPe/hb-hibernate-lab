package com.exemple;

import com.exemple.dao.ArticleDAO;
import com.exemple.dao.UserDAO;
import com.exemple.models.Article;
import com.exemple.models.User;

import java.util.ArrayList;
import java.util.List;

public class Seeding {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Démarrage du seeding");
        System.out.println("==========================================");
        System.out.println("\n");

        // ======= Création des entités ======= //
        User u1 = new User();
        u1.setNom("Léo");
        u1.setEmail("leotest@email.com");

        List<Article> ua1 = new ArrayList<>();
        Article a1 = new Article();
        a1.setTitle("Article 1");
        a1.setContent("This is my first article");
        a1.setAuthor(u1);
        Article a2 = new Article();
        a2.setTitle("Article 2");
        a2.setContent("This is my second article");
        a2.setAuthor(u1);
        Article a3 = new Article();
        a3.setTitle("Article 3");
        a3.setContent("This is my third article");
        a3.setAuthor(u1);
        Article a4 = new Article();
        a4.setTitle("Article 4");
        a4.setContent("This is my fourth article");
        a4.setAuthor(u1);
        Article a5 = new Article();
        a5.setTitle("Article 5");
        a5.setContent("This is my fifth article");
        a5.setAuthor(u1);
        Article a6 = new Article();
        a6.setTitle("Article 6");
        a6.setContent("This is my sixth article");
        a6.setAuthor(u1);
        Article a7 = new Article();
        a7.setTitle("Article 7");
        a7.setContent("This is my seventh article");
        a7.setAuthor(u1);

        ua1.add(a1);
        ua1.add(a2);
        ua1.add(a3);
        ua1.add(a4);
        ua1.add(a5);
        ua1.add(a6);
        ua1.add(a7);
        u1.setArticles(ua1);

        User u2 = new User();
        u2.setNom("Quentin");
        u2.setEmail("quentintest@email.com");

        List<Article> ua2 = new ArrayList<>();
        Article a8 = new Article();
        a8.setTitle("Article 8");
        a8.setContent("This is my first article");
        a8.setAuthor(u2);
        Article a9 = new Article();
        a9.setTitle("Article 9");
        a9.setContent("This is my second article");
        a9.setAuthor(u2);
        Article a10 = new Article();
        a10.setTitle("Article 10");
        a10.setContent("This is my third article");
        a10.setAuthor(u2);

        ua2.add(a8);
        ua2.add(a9);
        ua2.add(a10);
        u2.setArticles(ua2);



        // ======= Insertion des tuples en BDD ======= //
        UserDAO userDAO = new UserDAO(true);
        ArticleDAO articleDAO = new ArticleDAO(true);

        userDAO.create(u1);
        userDAO.create(u2);
        articleDAO.create(a1);
        articleDAO.create(a2);
        articleDAO.create(a3);
        articleDAO.create(a4);
        articleDAO.create(a5);
        articleDAO.create(a6);
        articleDAO.create(a7);
        articleDAO.create(a8);
        articleDAO.create(a9);
        articleDAO.create(a10);

    }
}
