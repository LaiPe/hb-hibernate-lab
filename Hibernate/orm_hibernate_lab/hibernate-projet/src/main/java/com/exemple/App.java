package com.exemple;

import com.exemple.model.Article;
import com.exemple.model.User;
import com.exemple.service.ArticleService;
import com.exemple.service.Service;
import com.exemple.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("       Démarrage de l'application");
        System.out.println("==========================================");
        System.out.println("\n");

        // ======= Création des entités ======= //
        User monUser = new User();
        monUser.setNom("Léo");
        monUser.setEmail("leotest@email.com");

        List<Article> mesArticles = new ArrayList<Article>();
        Article a1 = new Article();
        a1.setTitle("Article 1");
        a1.setContent("This is the first article");
        a1.setAuthor(monUser);
        Article a2 = new Article();
        a2.setTitle("Article 2");
        a2.setContent("This is the second article");
        a2.setAuthor(monUser);

        mesArticles.add(a1);
        mesArticles.add(a2);
        monUser.setArticles(mesArticles);


        // ======= Insertion des tuples en BDD ======= //
        UserService monServiceUser = new UserService();
        monServiceUser.create(monUser);

        ArticleService monServiceArticle = new ArticleService();
        monServiceArticle.create(a1);
        monServiceArticle.create(a2);



        // ======= Lecture du tuple ======= //
        User monUserLu = monServiceUser.read(1L); // lecture de l'id 1 de la table user
        monUserLu.setArticles(monServiceUser.readArticles(1L));

        monServiceUser.print(monUserLu);
        for (Article a : monUserLu.getArticles()) {
            monServiceArticle.print(a);
        }


        // ======= Modification du tuple ======= //
        monUser.setEmail("nouvelemail@email.com");
        monUser.setId(1L);
        monServiceUser.update(monUser);

        // ======= Lecture du tuple ======= //
        monUserLu = monServiceUser.read(1L);
        monServiceUser.print(monUserLu);


        // ======= Suppression du tuple ======= //
        monServiceUser.delete(2L);

        // ======= Lecture du tuple ======= //
        monUserLu = monServiceUser.read(2L);
        monServiceUser.print(monUserLu);

    }
}
