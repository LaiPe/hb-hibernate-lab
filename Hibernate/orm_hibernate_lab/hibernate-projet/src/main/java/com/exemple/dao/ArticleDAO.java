package com.exemple.dao;

import com.exemple.models.Article;
import jakarta.persistence.RollbackException;
import org.hibernate.JDBCException;
import org.hibernate.Session;

import java.util.List;


public class ArticleDAO extends GenericDAOImpl<Article,Long> implements GenericDAO<Article,Long> {

    public ArticleDAO(boolean verbose) {
        super(Article.class, verbose);
    }

    public List<Article> readAllByAuthor(Long authorId) {
        System.out.println("==========================================");
        System.out.println("            HQL query operation");
        System.out.println("==========================================");

        String query = "FROM Article a WHERE a.author.id = :authorId";

        List<Article> articles = null;

        try (Session session = sessionFactory.openSession()) {
            articles = session.createQuery(query, Article.class)
                    .setParameter("authorId", authorId)
                    .list();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("ERROR : Impossible to READ user's articles from userId " + authorId);
        }
        System.out.println("\n");
        return articles;
    }

    public List<Article> readAllByTitle(String title) {
        System.out.println("=========================================");
        System.out.println("            HQL query operation");
        System.out.println("=========================================");

        String query = "FROM Article a WHERE a.title LIKE :title";

        List<Article> articles = null;

        try (Session session = sessionFactory.openSession()) {
            articles = session.createQuery(query, Article.class)
                    .setParameter("title", "%" + title + "%")
                    .list();
        } catch (Exception e) {
            System.err.println("ERROR : Impossible to READ articles with title like " + title);
        }
        System.out.println("\n");
        return articles;
    }

}
