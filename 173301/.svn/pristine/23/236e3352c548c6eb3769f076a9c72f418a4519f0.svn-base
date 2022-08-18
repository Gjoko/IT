package edu.finki.gjoko.services.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
public class DateController {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @GetMapping(value = "/date")
    public String getMapping(@RequestParam(value = "time", required = false) String time,
                             HttpServletRequest request,
                             Model model) {
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        dateTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = new Date();

        List<String> paramNames = Collections.list(request.getParameterNames());

        if(paramNames.size() > 1 || (paramNames.size() == 1 && !paramNames.contains("time"))) {
            model.addAttribute("hasInvalidParams", true);
        } else {
            if(time != null) {
                model.addAttribute("time", dateTimeFormat.format(date));
            } else {
                model.addAttribute("time", dateFormat.format(date));
            }
        }
        return "Date";
    }
}
