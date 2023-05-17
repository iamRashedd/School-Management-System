package ecom.controller;



import ecom.domain.Course;
import ecom.domain.Teacher;
import ecom.domain.User;
import ecom.service.*;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;
    private TeacherService teacherService;
    private UserService userService;
    private StudentService studentService;

    public CourseController(CourseService courseService, TeacherService teacherService, UserService userService, StudentService studentService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.userService = userService;
        this.studentService = studentService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                setValue(localDate);
            }
        });

        webDataBinder.registerCustomEditor(Teacher.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                Teacher teacher = teacherService.get(Long.parseLong(text));
                setValue(teacher);
            }
        });
    }

    @RequestMapping("/list")
    public String list(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("courses", courseService.list());
        return "course/list";
    }
    @RequestMapping("/listByTeacher")
    public String listByTeacher(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("courses", courseService.listByTeacher(user.getId()));
        return "course/list";
    }
    @RequestMapping("/listByStudent")
    public String listByStudent(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("courses", studentService.getByUser(user.getId()).getCourses());
        return "course/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("course", new Course());
        model.addAttribute("teachers", teacherService.list());
        return "course/create";
    }


    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "course/create";
        }
        courseService.create(course);
        return "redirect:/courses/list";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam("courseId") Long courseId, Model model) {
        model.addAttribute("course", courseService.get(courseId));
        model.addAttribute("teachers", teacherService.list());
        return "course/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "course/edit";
        }
        courseService.update(course);
        return "redirect:/courses/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("courseId") Long courseId) {
        courseService.delete(courseId);
        return "redirect:/courses/list";
    }
}
