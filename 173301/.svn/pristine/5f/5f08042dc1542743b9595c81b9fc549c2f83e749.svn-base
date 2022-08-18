package edu.finki.gjoko.services.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GuessNumberController {

    private final int IMAGINED_NUMBER = 3;


    @GetMapping(value = "/guess_number")
    public String getMapping(@RequestParam(value = "operand1", required = false) Integer operand1,
                             HttpServletRequest request,
                             Model model) {
        return processRequest(operand1, request, model);
    }

    @PostMapping(value = "/guess_number")
    public String postMapping(@RequestParam(value = "operand1", required = false) Integer operand1,
                                            HttpServletRequest request,
                                            Model model) {
        return processRequest(operand1, request, model);
   }

   private String processRequest(Integer operand1, HttpServletRequest request, Model model) {
       Map<String, String[]> map = request.getParameterMap();
       if(map.size() > 1 || (map.size() == 1 && (!map.containsKey("operand1") || map.get("operand1")[0] == ""))) {
           model.addAttribute("title", "ERROR");
           return "Error";
       } else if(map.size() == 0) {
           model.addAttribute("title", "HELP");
           return "Error";
       } else {
           model.addAttribute("result", compareNumber(IMAGINED_NUMBER, operand1));
           return "GuessNumber";
       }
   }

   private int compareNumber(int imaginedNumber, int guessedNumber) {
        if(imaginedNumber == guessedNumber) {
            return 0;
        } else if (imaginedNumber < guessedNumber) {
            return 1;
        } else {
            return -1;
        }
   }

}
