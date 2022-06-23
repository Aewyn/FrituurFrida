package com.example.frituurfrida.controllers;

import com.example.frituurfrida.services.SausService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sauzen")
public class SausController {
    private final SausService sausService;
    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    //private final SausService sausService = new SausService(new CSVSausRepository());
    public SausController(SausService sausService){
        this.sausService = sausService;
    }
    @GetMapping
    private ModelAndView findAll() {
        return new ModelAndView("sauzen", "alleSauzen", sausService.findAll());
    }
    @GetMapping("{id}")
    public ModelAndView findById(@PathVariable long id) {
        var modelAndView = new ModelAndView("saus");
        sausService.findById(id).ifPresent(gevondenSaus -> modelAndView.addObject("saus", gevondenSaus));
        return modelAndView;
    }
    @GetMapping("alfabet")
    public ModelAndView alfabet() {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet);
    }
    @GetMapping("alfabet/{letter}")
    public ModelAndView findByBeginNaam(@PathVariable char letter) {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet)
                .addObject("sauzen", sausService.findByBeginNaam(letter));
    }
}
