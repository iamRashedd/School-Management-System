package ecom.repository;

import ecom.domain.Authority;
import ecom.domain.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorityRepository {
    private SessionFactory sessionFactory;

    public AuthorityRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Authority> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Authority> authorityTypedQuery = session.createQuery("from Authorities", Authority.class);
        return authorityTypedQuery.getResultList();
    }

    public boolean create(Authority authority) {
        Session session = sessionFactory.getCurrentSession();
        session.save(authority);
        return true;
    }

    public Authority get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Authority.class, id);
    }
    public Authority getByUser(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Authority> authorityTypedQuery = session.createQuery("from authorities Where user_id = :user_id", Authority.class);
        authorityTypedQuery.setParameter("user_id",userId);
        return authorityTypedQuery.getSingleResult();
    }

    public boolean update(Authority authority) {
        Session session = sessionFactory.getCurrentSession();
        session.update(authority);
        return true;
    }

    public boolean delete(Authority authority) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(authority);
        return true;
    }
    public boolean deleteByUser(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete("from authorities Where user_id = "+userId, Authority.class);
        //authorityTypedQuery.setParameter("user_id",userId);
        //authorityTypedQuery.executeUpdate();
        return true;
    }
}
