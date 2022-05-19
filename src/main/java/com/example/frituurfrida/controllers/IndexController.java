package com.example.frituurfrida.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index(){
        var zijnWeOpen = LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY ? "gesloten" : "geopend";
        return "<!doctype html><html><title>Hallo</title><body>We zijn "
                + zijnWeOpen +
                "</body></html>";
    }
}
