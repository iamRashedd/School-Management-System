package ecom.service;



import ecom.domain.Student;
import ecom.domain.Teacher;
import ecom.domain.User;
import ecom.domain.UserType;
import ecom.dto.StudentDto;
import ecom.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class StudentService {

    private Logger logger = Logger.getLogger(StudentService.class.getName());

    private StudentRepository studentRepository;
    private UserService userService;

    public StudentService(StudentRepository studentRepository, UserService userService) {
        this.studentRepository = studentRepository;
        this.userService = userService;
    }

    public List<Student> list() {
        return studentRepository.list();
    }

    public Student get(Long id) {
        return studentRepository.get(id);
    }
    public Student getByUser(Long userId) {
        return studentRepository.getByUser(userId);
    }

    public boolean create(Student student) {
        return studentRepository.create(student);
    }

    public boolean create(StudentDto studentDto) {

        User user = new User();
        user.setUsername(studentDto.getUsername());
        user.setName(studentDto.getName());
        user.setPassword(studentDto.getPassword());
        user.setEnabled(false);
        user.setCreatedOn(LocalDate.now());
        user.setUserType(UserType.STUDENT);
        userService.create(user);

        Student student = new Student();
        student.setDob(studentDto.getDob());
        student.setDepartment(studentDto.getDepartment());
        student.setSemester(studentDto.getSemester());
        student.setCompleted_credits(studentDto.getCompleted_credits());
        student.setUser(user);

        return studentRepository.create(student);
    }

    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    public boolean delete(Long id) {
        return studentRepository.delete(get(id));
    }
}
