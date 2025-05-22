package com.exemple;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.exemple.dao.DBAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnnonceDAOTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void setUpBeforeClass() {
        sessionFactory = new Configuration()
                .configure()
                .setProperty("jakarta.persistence.jdbc.url", "jdbc:mysql://test-mysql:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true")
                .buildSessionFactory();
    }

    @BeforeEach
    public void setUp() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
