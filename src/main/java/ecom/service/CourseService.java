package ecom.service;


import ecom.domain.Course;
import ecom.repository.CourseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CourseService {

    private Logger logger = Logger.getLogger(StudentService.class.getName());

    private CourseRepository courseRepository;
    private TeacherService teacherService;
    private StudentService studentService;

    public CourseService(CourseRepository courseRepository, TeacherService teacherService, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    public List<Course> list() {
        return courseRepository.list();
    }
    public List<Course> listByTeacher(Long userId) {
        return courseRepository.listByTeacher(teacherService.getByUser(userId).getId());
    }
    /*
    public List<Course> listByStudent(Long userId) {
        return courseRepository.listByStudent(studentService.getByUser(userId).getId());
    }*/

    public Course get(Long id) {
        return courseRepository.get(id);
    }

    public boolean create(Course course) {
        return courseRepository.create(course);
    }


    public boolean update(Course course) {
        return courseRepository.update(course);
    }

    public boolean delete(Long id) {
        return courseRepository.delete(get(id));
    }
}
