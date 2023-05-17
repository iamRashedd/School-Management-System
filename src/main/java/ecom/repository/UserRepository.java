package ecom.repository;

import ecom.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.List;

@Repository
public class UserRepository {
    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User", User.class);
        return userQuery.getResultList();
    }

    public boolean create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return true;
    }

    public User get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public User get(String username) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<User> userQuery = session.createQuery("from User Where username = :username", User.class);
        userQuery.setParameter("username",username);
        return userQuery.getSingleResult();
    }

    public boolean update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }

    public boolean delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        return true;
    }
}
