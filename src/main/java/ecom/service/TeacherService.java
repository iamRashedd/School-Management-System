package ecom.service;

import ecom.domain.*;
import ecom.dto.TeacherDto;
import ecom.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class TeacherService {

    private Logger logger = Logger.getLogger(TeacherService.class.getName());

    private TeacherRepository teacherRepository;
    private UserService userService;

    public TeacherService(TeacherRepository teacherRepository, UserService userService) {
        this.teacherRepository = teacherRepository;
        this.userService = userService;
    }

    public List<Teacher> list() {
        return teacherRepository.list();
    }

    public Teacher get(Long id) {
        return teacherRepository.get(id);
    }

    public Teacher getByUser(Long userId) {
        return teacherRepository.getByUser(userId);
    }

    public boolean create(Teacher teacher) {
        return teacherRepository.create(teacher);
    }

    public boolean create(TeacherDto teacherDto) {

        User user = new User();
        user.setUsername(teacherDto.getUsername());
        user.setName(teacherDto.getName());
        user.setPassword(teacherDto.getPassword());
        user.setEnabled(false);
        user.setCreatedOn(LocalDate.now());
        user.setUserType(UserType.TEACHER);
        userService.create(user);

        Teacher teacher = new Teacher();
        teacher.setDepartment(teacherDto.getDepartment());
        teacher.setSalary(teacherDto.getSalary());
        teacher.setUser(user);

        return teacherRepository.create(teacher);
    }

    public boolean update(Teacher teacher) {
        return teacherRepository.update(teacher);
    }
    public boolean update(TeacherDto teacherDto) {
        User user = userService.get(teacherDto.getUsername());
        user.setName(teacherDto.getName());
        userService.update(user);
        Teacher teacher = teacherRepository.get(teacherDto.getId());
        teacher.setUser(user);
        teacher.setDepartment(teacherDto.getDepartment());
        teacher.setSalary(teacherDto.getSalary());
        return teacherRepository.update(teacher);
    }

    public boolean delete(Long id) {
        return teacherRepository.delete(get(id));
    }
}
