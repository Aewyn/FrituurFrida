package com.example.frituurfrida.controllers;

import com.example.frituurfrida.domain.Adres;
import com.example.frituurfrida.domain.Gemeente;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

@RestController
public class IndexController {
    private static final int EEN_JAAR_IN_SECONDEN = 31_536_000;
    @GetMapping("/")
    public ModelAndView index(@CookieValue Optional<Integer> aantalBezoeken, HttpServletResponse response) {
        var nieuwAantalBezoeken = aantalBezoeken.orElse(0) + 1;
        var cookie = new Cookie("aantalBezoeken", String.valueOf(nieuwAantalBezoeken));
        cookie.setMaxAge(EEN_JAAR_IN_SECONDEN);
        cookie.setPath("/");
        response.addCookie(cookie);
        var zijnWeOpen = LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY ? "gesloten" : "geopend";
        var modelAndView = new ModelAndView("index", "openingsdag", zijnWeOpen);
        modelAndView.addObject("adresgegevens",
                new Adres("Frietjesstraat", "88",
                        new Gemeente("Frittegem", 2544)));
        modelAndView.addObject("aantalBezoeken", nieuwAantalBezoeken);
        return modelAndView;
    }
}
