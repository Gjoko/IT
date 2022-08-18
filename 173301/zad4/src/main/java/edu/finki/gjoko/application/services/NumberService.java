package edu.finki.gjoko.application.services;

import edu.finki.gjoko.application.dto.Number;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class NumberService {

    public String fetchResult(Number number) throws IOException {
        String url = "";
        switch (number.getType()) {
            case "cgi":
                url = "http://localhost:8081/guess_number.cgi";
                break;
            case "java":
                url = "http://localhost:8082/services/guess_number";
                break;
            case "dotnet":
                url = "http://localhost:8083/guess_number";
                break;
            default:
                break;
        }

        if (!url.isBlank() && !number.getOperand1().isBlank()) {
            url += "?operand1=" + number.getOperand1();
        }

        Document document = Jsoup.connect(url).get();
        return document.select("body").text();
    }
}
