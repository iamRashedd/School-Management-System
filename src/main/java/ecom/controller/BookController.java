package ecom.controller;


import ecom.domain.Book;
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
@RequestMapping("/books")
public class BookController {


    private BookService bookService;
    private UserService userService;
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
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

        webDataBinder.registerCustomEditor(Book.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                Book book = bookService.get(Long.parseLong(text));
                setValue(book);
            }
        });
    }

    @RequestMapping("/list")
    public String list(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("books", bookService.list());
        return "book/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.get(username);
        model.addAttribute("profile", user);
        model.addAttribute("book", new Book());
        return "book/create";
    }


    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "book/create";
        }
        bookService.create(book);
        return "redirect:/books/list";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam("bookId") Long bookId, Model model) {
        model.addAttribute("book", bookService.get(bookId));
        return "book/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "book/edit";
        }
        bookService.update(book);
        return "redirect:/books/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("bookId") Long bookId) {
        bookService.delete(bookId);
        return "redirect:/books/list";
    }
}
