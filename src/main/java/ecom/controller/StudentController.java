package ecom.controller;


import ecom.domain.Student;
import ecom.domain.User;
import ecom.dto.StudentDto;
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
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    private UserService userService;

    public StudentController(StudentService studentService, UserService userService) {
        this.studentService = studentService;
        this.userService = userService;

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
    }

    @RequestMapping("/list")
    public String list(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("students", studentService.list());
        return "student/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("studentDto", new StudentDto());
        return "student/create";
    }


    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("studentDto") StudentDto studentDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "student/create";
        }

        studentService.create(studentDto);
        return "redirect:/students/list";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam("studentId") Long studentId, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("student", studentService.get(studentId));
        return "student/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "student/edit";
        }
        studentService.update(student);
        return "redirect:/students/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") Long studentId) {
        studentService.delete(studentId);
        return "redirect:/students/list";
    }
}
