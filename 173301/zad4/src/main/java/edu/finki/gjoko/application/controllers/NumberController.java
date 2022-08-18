package edu.finki.gjoko.application.controllers;

import edu.finki.gjoko.application.dto.Number;
import edu.finki.gjoko.application.services.NumberService;
import edu.finki.gjoko.application.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class NumberController {

    private final NumberService numberService;

    private final UserService userService;


    public NumberController(NumberService numberService, UserService userService) {
        this.numberService = numberService;
        this.userService = userService;
    }

    @GetMapping(value = "/number")
    public String getMapping(@ModelAttribute Number number, Model model) {
        userService.setHeader(model);
        return "number";
    }

    @PostMapping(value = "/number")
    public String postMapping(@ModelAttribute Number number, Model model) throws IOException {
        userService.setHeader(model);
        String numberString = numberService.fetchResult(number);
        model.addAttribute("result", numberString);
        return "number";
    }

}
