package ecom.controller;

import ecom.domain.Teacher;
import ecom.domain.User;
import ecom.dto.TeacherDto;
import ecom.service.TeacherService;
import ecom.service.UserService;
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

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherService teacherService;
    private UserService userService;

    public TeacherController(TeacherService teacherService, UserService userService) {
        this.teacherService = teacherService;
        this.userService = userService;

    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

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
        model.addAttribute("teachers", teacherService.list());
        return "teacher/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("teacherDto", new TeacherDto());
        return "teacher/create";
    }


    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("teacherDto") TeacherDto teacherDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "teacher/create";
        }

        teacherService.create(teacherDto);
        return "redirect:/teachers/list";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam("teacherId") Long teacherId, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        Teacher teacher = teacherService.get(teacherId);
        TeacherDto teacherDto = new TeacherDto(teacher.getId(),teacher.getUser().getUsername(), teacher.getUser().getName(), teacher.getUser().getPassword(),teacher.getDepartment(),teacher.getSalary());
        model.addAttribute("teacherDto", teacherDto);
        return "teacher/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("teacherDto") TeacherDto teacherDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "teacher/edit";
        }
        teacherService.update(teacherDto);
        return "redirect:/teachers/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("teacherId") Long teacherId) {
        teacherService.delete(teacherId);
        return "redirect:/teachers/list";
    }
}
