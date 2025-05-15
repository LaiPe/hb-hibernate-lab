package com.exemple;

import com.exemple.models.Article;
import com.exemple.models.User;
import com.exemple.dao.ArticleDAO;
import com.exemple.dao.UserDAO;

import java.util.ArrayList;
import java.util.List;

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
        UserDAO userDAO = new UserDAO(true);
        userDAO.create(monUser);

        ArticleDAO articleDAO = new ArticleDAO(true);
        articleDAO.create(a1);
        articleDAO.create(a2);



        // ======= Lecture du tuple ======= //
        User monUserLu = userDAO.read(1L); // lecture de l'id 1 de la table user
        monUserLu.setArticles(articleDAO.readAllByAuthor(1L));

        monUserLu.print();
        for (Article a : monUserLu.getArticles()) {
            a.print();
        }


        // ======= Modification du tuple ======= //
        monUser.setEmail("nouvelemail@email.com");
        monUser.setId(1L);
        userDAO.update(monUser);

        // ======= Lecture du tuple ======= //
        monUserLu = userDAO.read(1L);
        monUserLu.print();


        // ======= Suppression du tuple ======= //
        userDAO.delete(2L);

        // ======= Lecture du tuple ======= //
        monUserLu = userDAO.read(2L);
        monUserLu.print();



        // ======= Lecture de tous les tuples ======= //
        List<User> mesUsers = userDAO.readAll();
        for (User u : mesUsers) {
            u.print();
        }

        // ======= Lecture d'un tuple trouvé par email ======= //
        monUserLu = userDAO.readByEmail("nouvelemail@email.com");
        monUserLu.print();


        // ======= Lecture de tuples trouvés par titre ======= //
        List<Article> articlesLus = articleDAO.readAllByTitle("1");
        System.out.println(articlesLus);
        for (Article a : articlesLus) {
            a.print();
        }

        while (true) {
            int p = 1;
        }

    }
}
