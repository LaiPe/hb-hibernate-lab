package com.exemple.service;

import com.exemple.DBAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Service<A> {
    private final Class<A> modelType;
    private final SessionFactory sessionFactory;

    public Service(Class<A> modelType) {
        this.modelType = modelType;
        this.sessionFactory = DBAccess.getInstance().getSessionFactory();
    }

    public void create(A entity){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public A read(Long id){
        A entity = null;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            entity = session.get(modelType, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return entity;
    }

    public void update(A entity){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void delete(Long id){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
