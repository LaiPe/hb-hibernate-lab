package com.exemple.dao;

import com.exemple.models.Article;
import com.exemple.models.User;
import jakarta.persistence.RollbackException;
import org.hibernate.JDBCException;
import org.hibernate.Session;

import java.util.List;

public class UserDAO extends GenericDAOImpl<User,Long> implements GenericDAO<User,Long> {

    public UserDAO(boolean verbose) {
        super(User.class, verbose);
    }

    public User readByEmail(String email) {
        System.out.println("==========================================");
        System.out.println("            HQL query operation");
        System.out.println("==========================================");

        String query = "FROM User u WHERE u.email = :email";

        User user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.createQuery(query, User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("ERROR : Impossible to READ user from email " + email);
        }
        System.out.println("\n");
        return user;
    }
}
