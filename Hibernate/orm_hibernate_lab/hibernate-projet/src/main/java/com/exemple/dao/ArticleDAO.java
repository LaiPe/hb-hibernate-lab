package com.exemple.dao;

import com.exemple.models.Article;
import jakarta.persistence.RollbackException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.JDBCException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class ArticleDAO extends GenericDAOImpl<Article,Long> implements GenericDAO<Article,Long> {

    public ArticleDAO(boolean verbose) {
        super(Article.class, verbose);
    }

    public List<Article> readAllBy(Long authorId) {
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

    public List<Article> readAllBy(String title) {
        System.out.println("=========================================");
        System.out.println("            HQL query operation");
        System.out.println("=========================================");

        String query = "FROM Article a WHERE a.title LIKE :title";

        List<Article> articles = null;

        try (Session session = sessionFactory.openSession()) {
            articles = session.createQuery(query, Article.class)
                    .setParameter("title", "%" + title + "%")
                    .list();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("ERROR : Impossible to READ articles with title like " + title);
        }
        System.out.println("\n");
        return articles;
    }

    public List<Article> readAllBy(Long authorId, String title, int limit) {
        System.out.println("=========================================");
        System.out.println("         Criteria query operation");
        System.out.println("=========================================");

        List<Article> articles = null;

        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Article> query = cb.createQuery(Article.class);
            Root<Article> root = query.from(Article.class);

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("author").get("id"), authorId));
            predicates.add(cb.like(cb.lower(root.get("title")),"%" + title + "%"));

            query.select(root)
                    .where(predicates.toArray(new Predicate[predicates.size()]))
                    .orderBy(cb.asc(root.get("title")));

            articles = session.createQuery(query).setMaxResults(limit).list();

        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("ERROR : Impossible to READ articles from authorId " + authorId + " and title " + title);
        }
        System.out.println("\n");
        return articles;

    }

}
