package edu.finki.gjoko.services.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getMapping() {
        return "Index";
    }

    @PostMapping("/")
    public String postMapping() {
        return "Index";
    }
}
