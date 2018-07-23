package com.github.stanislavnikles.onlinelibrary.controller;

import com.github.stanislavnikles.onlinelibrary.domain.Book;
import com.github.stanislavnikles.onlinelibrary.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = {"/", "/home"})
    public String getMainPage(Model model) {
        final List<Book> popular = bookService.findPopular();
        model.addAttribute("popular", popular);
        return "home";
    }
}
