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


        UserDAO userDAO = new UserDAO(true);
        ArticleDAO articleDAO = new ArticleDAO(true);

        /*
        // ======= Lecture du tuple ======= //
        User monUserLu = userDAO.read(1L); // lecture de l'id 1 de la table user
        monUserLu.setArticles(articleDAO.readAllBy(1L));

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
        List<Article> articlesLus = articleDAO.readAllBy("1");
        System.out.println(articlesLus);
        for (Article a : articlesLus) {
            a.print();
        }
        */

        // ======= Lecture de tuples trouvés par auteur et titre ======= //
        List<Article> autresArticlesLus = articleDAO.readAllBy(1L,"Article",5);
        System.out.println(autresArticlesLus);
        for (Article a : autresArticlesLus) {
            a.print();
        }

        while (true) {
            int p = 1;
        }

    }
}
