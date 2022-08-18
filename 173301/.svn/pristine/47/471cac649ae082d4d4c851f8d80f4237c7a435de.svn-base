package edu.finki.gjoko.application.controllers;

import edu.finki.gjoko.application.dto.Date;
import edu.finki.gjoko.application.services.DateService;
import edu.finki.gjoko.application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class DateController {

    private final UserService userService;

    private final DateService dateService;

    public DateController(UserService userService, DateService dateService) {
        this.userService = userService;
        this.dateService = dateService;
    }

    @GetMapping(value = "/date")
    public String getMapping(@ModelAttribute Date date, Model model) {
        userService.setHeader(model);
        return "date";
    }

    @PostMapping(value = "/date")
    public String postMapping(@ModelAttribute Date date, Model model) throws IOException {
        userService.setHeader(model);
        String dateString = dateService.fetchDate(date);
        model.addAttribute("result", dateString);
        return "date";
    }


}
