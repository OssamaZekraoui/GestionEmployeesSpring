package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){

        return "AccessDenied";
    }

    @GetMapping("/***")
    public String login(){

        return "login";
    }
}
