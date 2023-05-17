package ecom.repository;


import ecom.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepository {
    private SessionFactory sessionFactory;

    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Book> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Book> bookTypedQuery = session.createQuery("from Book", Book.class);
        return bookTypedQuery.getResultList();
    }

    public boolean create(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
        return true;
    }

    public Book get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }

    public boolean update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        return true;
    }

    public boolean delete(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);
        return true;
    }
}
