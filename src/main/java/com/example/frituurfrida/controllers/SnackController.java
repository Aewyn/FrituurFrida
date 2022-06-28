package com.example.frituurfrida.controllers;

import com.example.frituurfrida.controllers.forms.ZoekOpLetterForm;
import com.example.frituurfrida.services.SnackService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("snacks")
public class SnackController {
    private final SnackService snackService;

    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public SnackController(SnackService snackService){
        this.snackService = snackService;
    }

    @GetMapping
    public ModelAndView alfabet(){
        return new ModelAndView("snacks","alfabet", alfabet);
    }
    @GetMapping("{letter}")
    public ModelAndView findByBeginNaam(@PathVariable String letter) {
        return new ModelAndView("snacks", "alfabet", alfabet)
                .addObject("snacks", snackService.findByBeginNaam(letter));
    }
    @GetMapping("/aantalverkochtesnacks")
    public ModelAndView findAantalVerkochteSnacks(){
        return new ModelAndView("aantalverkochtesnacks", "aantalVerkochteSnacks",snackService.findAantalVerkochteSnacks());
    }

    @GetMapping("/zoekopletter")
    public ModelAndView findByBeginNaam(@Valid ZoekOpLetterForm form, Errors errors){
        var modelAndView = new ModelAndView("zoekopletter");
        if(errors.hasErrors()){
            return modelAndView;
        }
        return modelAndView.addObject("snacksMetLetter", snackService.findByBeginNaam(form.beginLetter()));
    }

    @GetMapping("/zoekopletter/form")
    public ModelAndView zoekOpLetterForm(){
        return new ModelAndView("zoekopletter").addObject(new ZoekOpLetterForm(""));
    }
}
