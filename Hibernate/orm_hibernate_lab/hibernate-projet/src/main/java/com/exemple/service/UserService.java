package com.exemple.service;

import com.exemple.model.Article;
import com.exemple.model.User;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService extends Service<User> {

    public UserService() {
        super(User.class);
    }

    public void print(User entity) {
        Map<String,String> attributes = new HashMap<String,String>();
        if (entity != null) {
            attributes.put("ID", entity.getId().toString());
            attributes.put("nom", entity.getNom());
            attributes.put("email", entity.getEmail());
        }
        print(attributes);
    }

    public List<Article> readArticles(Long userId) {
        System.out.println("==========================================");
        System.out.println("           JPQL query operation");
        System.out.println("==========================================");

        String query = "SELECT a FROM Article a WHERE a.author.id = :authorId";

        List<Article> articles = null;

        try (Session session = sessionFactory.openSession()) {
            articles = session.createQuery(query, Article.class)
                    .setParameter("authorId", userId)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("ERROR : Impossible to READ user's articles from userId " + userId);
        }
        System.out.println("\n");
        return articles;
    }
}
