package com.example.frituurfrida.controllers;

import com.example.frituurfrida.domain.Adres;
import com.example.frituurfrida.domain.Gemeente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
public class IndexController {
    @GetMapping("/")
    public ModelAndView index(){
        var zijnWeOpen = LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY ? "gesloten" : "geopend";
        var modelAndView = new ModelAndView("index", "openingsdag", zijnWeOpen);
        modelAndView.addObject("adresgegevens",
                new Adres("Frietjesstraat", "88",
                new Gemeente("Frittegem", 2544)));
        return modelAndView;
    }
}
