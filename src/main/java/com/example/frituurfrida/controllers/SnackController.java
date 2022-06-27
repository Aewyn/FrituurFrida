package com.example.frituurfrida.controllers;

import com.example.frituurfrida.services.SnackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("snacks")
public class SnackController {
    private final SnackService snackService;

    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public SnackController(SnackService snackService){
        this.snackService = snackService;
    }

    @GetMapping
    private ModelAndView alfabet(){
        return new ModelAndView("snacks","alfabet", alfabet);
    }
    @GetMapping("{letter}")
    private ModelAndView findByBeginNaam(@PathVariable String letter) {
        return new ModelAndView("snacks", "alfabet", alfabet)
                .addObject("snacks", snackService.findByBeginNaam(letter));
    }
}
