package ecom.controller;

import ecom.domain.User;
import ecom.domain.UserType;
import ecom.dto.UserDto;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
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

        webDataBinder.registerCustomEditor(User.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                User user = userService.get(Long.parseLong(text));
                setValue(user);
            }
        });
    }

    @RequestMapping("/list")
    public String list(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("users", userService.list());
        return "user/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("user", new User());
        return "user/create";
    }


    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        user.setEnabled(false);
        user.setCreatedOn(LocalDate.now());
        user.setUserType(UserType.ADMIN);
        userService.create(user);
        return "redirect:/users/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("userId") Long userId, Model model) throws SQLException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        User user1 = userService.get(userId);
        UserDto userDto = new UserDto(user1.getId(), user1.getUsername(), user1.getName(), user1.getPassword(), user1.isEnabled(), user1.getCreatedOn(), user1.getUserType());
        model.addAttribute("profile", user);
        model.addAttribute("userDto", userDto);
        return "user/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }

        userService.update(userDto);
        return "redirect:/users/list";
    }
    @RequestMapping("/authorize")
    public String authorize(@RequestParam("userId") Long userId){
        userService.authorize(userId);
        return "redirect:/users/list";
    }
    @RequestMapping("/unauthorize")
    public String unauthorize(@RequestParam("userId") Long userId){
        userService.unauthorize(userId);
        return "redirect:/users/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") Long userId) {
        userService.delete(userId);
        return "redirect:/users/list";
    }
}
