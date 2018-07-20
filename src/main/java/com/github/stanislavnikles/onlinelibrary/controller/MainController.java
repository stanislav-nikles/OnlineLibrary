package com.github.stanislavnikles.onlinelibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "/main"})
    public String getMainPage(Model model) {
        model.addAttribute("message", "Online Library!");
        return "main";
    }
}
