package ecom.repository;

import ecom.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TeacherRepository {
    private SessionFactory sessionFactory;

    public TeacherRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Teacher> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Teacher> teacherTypedQuery = session.createQuery("from Teacher", Teacher.class);
        return teacherTypedQuery.getResultList();
    }

    public boolean create(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
        return true;
    }

    public Teacher get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }
    public Teacher getByUser(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Teacher> teacherTypedQuery = session.createQuery("from Teacher Where user_id = :user_id", Teacher.class);
        teacherTypedQuery.setParameter("user_id",userId);
        return teacherTypedQuery.getSingleResult();
    }

    public boolean update(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
        return true;
    }

    public boolean delete(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(teacher);
        return true;
    }
}
