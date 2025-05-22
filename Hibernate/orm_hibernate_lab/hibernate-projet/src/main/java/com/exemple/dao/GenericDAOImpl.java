package com.exemple.dao;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.RollbackException;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class GenericDAOImpl<T,ID> implements GenericDAO<T,ID> {
    private final Class<T> modelType;
    private final String modelTypeName;
    protected final SessionFactory sessionFactory;

    private boolean verbose;

    public GenericDAOImpl(Class<T> modelType, boolean verbose) {
        this.modelType = modelType;
        this.modelTypeName = modelType.getSimpleName();

        this.sessionFactory = DBAccess.getInstance().getSessionFactory();

        this.verbose = verbose;
    }

    public void create(T entity){
        System.out.println("==========================================");
        System.out.println("          CRUD operation CREATE");
        System.out.println("==========================================");

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("CRUD ERROR : Impossible to CREATE entity " + modelTypeName);
        }
        System.out.println("\n");
    }

    public T read(ID id){
        System.out.println("==========================================");
        System.out.println("           CRUD operation READ");
        System.out.println("==========================================");

        T entity = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(modelType, id);
            session.getTransaction().commit();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("CRUD ERROR : Impossible to READ entity " + modelTypeName + " of id " + id);
        }
        System.out.println("\n");
        return entity;
    }

    public void update(T entity){
        System.out.println("==========================================");
        System.out.println("          CRUD operation UPDATE");
        System.out.println("==========================================");

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("CRUD ERROR : Impossible to UPDATE entity " + modelTypeName);
        }
        System.out.println("\n");
    }

    public void delete(ID id){
        System.out.println("==========================================");
        System.out.println("          CRUD operation DELETE");
        System.out.println("==========================================");

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(session.get(modelType, id));
            session.getTransaction().commit();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("CRUD ERROR : Impossible to DELETE entity " + modelTypeName + " of id " + id);
        }
        System.out.println("\n");
    }

    @Override
    public List<T> readAll() {
        System.out.println("==========================================");
        System.out.println("           HQL query operation");
        System.out.println("==========================================");

        List<T> entities = null;

        try (Session session = sessionFactory.openSession()) {
            entities = session.createQuery("FROM " + modelTypeName, modelType).list();
        } catch (JDBCException | IllegalStateException | RollbackException e) {
            System.err.println("CRUD ERROR : Impossible to READ entities " + modelTypeName + " for table");
        }
        System.out.println("\n");
        return entities;
    }

    protected boolean isVerbose() {
        return verbose;
    }
}
