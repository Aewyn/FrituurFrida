package com.example.frituurfrida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static java.util.Map.entry;

@Controller
@RequestMapping("taal")
public class TaalController {
    private static final Map<String,String> TALEN = Map.ofEntries(
            entry("en-US", "Engels, Verenigde Staten"),
            entry("fr", "Frans"),
            entry("en", "Engels"),
            entry("nl","Nederlands"));

    @GetMapping
    public ModelAndView taal(@RequestHeader("accept-language") String acceptLanguage){
        var modelAndView = new ModelAndView("taal");
        TALEN.entrySet().stream().filter(taal -> acceptLanguage.contains(taal.getKey()))
                .findFirst()
                .ifPresent(gevondenTaal -> modelAndView.addObject("taal", gevondenTaal.getValue()));
        return modelAndView;
    }
}
