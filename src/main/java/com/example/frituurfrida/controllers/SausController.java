package com.example.frituurfrida.controllers;

import com.example.frituurfrida.forms.SausRadenForm;
import com.example.frituurfrida.services.SausService;
import com.example.frituurfrida.sessions.RaadDeSaus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Random;

@Controller
@RequestMapping("sauzen")
public class SausController {
    private final SausService sausService;
    private final RaadDeSaus raadDeSaus;
    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public SausController(SausService sausService, RaadDeSaus raadDeSaus){
        this.sausService = sausService;
        this.raadDeSaus = raadDeSaus;
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

    private String randomSaus(){
        var sauzen = sausService.findAll().stream().toList();
        var random = new Random();
        var randomIndex = random.nextInt(sauzen.size());
        return sauzen.get(randomIndex).getNaam();
    }

    @GetMapping("raden")
    public ModelAndView radenForm(){
        raadDeSaus.reset(randomSaus());
        return new ModelAndView("sausRaden")
                .addObject("sausRaden", raadDeSaus)
                .addObject(new SausRadenForm(null));
    }

    @PostMapping("raden/nieuwspel")
    public String nieuwSpel(){
        return "redirect:/sauzen/raden";
    }

    @PostMapping("raden")
    public ModelAndView raden (@Valid SausRadenForm form, Errors errors){
        if(errors.hasErrors()){
            return new ModelAndView("sausRaden")
                    .addObject("sausRaden",raadDeSaus);
        }
        raadDeSaus.gok(form.letter());
        return new ModelAndView("redirect:/sauzen/raden/volgendegok");
    }

    @GetMapping("raden/volgendegok")
    public ModelAndView volgendeGok(){
        return new ModelAndView("sausRaden").addObject("sausRaden",raadDeSaus)
                .addObject(new SausRadenForm(null));
    }
}
