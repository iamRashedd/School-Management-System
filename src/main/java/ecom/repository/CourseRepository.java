package ecom.repository;


import ecom.domain.Course;
import ecom.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CourseRepository {
    private SessionFactory sessionFactory;

    public CourseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Course> list() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Course> courseTypedQuery = session.createQuery("from Course", Course.class);
        return courseTypedQuery.getResultList();
    }
    public List<Course> listByTeacher(Long teacherId) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Course> courseTypedQuery = session.createQuery("from Course Where teacher_id = :teacher_id", Course.class);
        courseTypedQuery.setParameter("teacher_id",teacherId);
        return courseTypedQuery.getResultList();
    }

    public boolean create(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
        return true;
    }

    public Course get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    public boolean update(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.update(course);
        return true;
    }

    public boolean delete(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(course);
        return true;
    }
}
