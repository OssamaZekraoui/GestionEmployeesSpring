package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Home";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){

        return "AccessDenied";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }


}
