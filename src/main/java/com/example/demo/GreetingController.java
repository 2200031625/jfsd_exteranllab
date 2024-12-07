package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
public class GreetingController {
    @RequestMapping("/greet")
    public String greet(@RequestParam("username") String username, Model model) {
        model.addAttribute("message", "Hello, " + username + "!");
        return "greet";
    }
}
