package com.example.frituurfrida.controllers;

import com.example.frituurfrida.domain.Saus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@RequestMapping("sauzen")
public class SausController {
    private final Saus[] alleSauzen = {
            new Saus(1, "cocktail", new String[]{"mayonaise", "ketchup", "whisky"}),
            new Saus(2, "mayonaise", new String[]{"olie", "eidooiers", "mosterd", "azijn"}),
            new Saus(3, "mosterd", new String[]{"mosterdzaad", "water", "zout", "azijn"}),
            new Saus(4, "tartare", new String[]{"eitjes", "augurk", "kappertjes", "mayonaise", "verse kruiden"}),
            new Saus(5, "vinaigrette", new String[]{"wijnazijn", "mosterd", "olie"})
    };

    @GetMapping
    private ModelAndView findAll() {
        return new ModelAndView("sauzen", "alleSauzen", alleSauzen);
    }

    private Optional<Saus> findByIdHelper(long id) {
        return Arrays.stream(alleSauzen).filter(saus -> saus.getNummer() == id).findFirst();
    }

    @GetMapping("{id}")
    public ModelAndView findById(@PathVariable long id) {
        var modelAndView = new ModelAndView("saus");
        findByIdHelper(id).ifPresent(gevondenSaus -> modelAndView.addObject("saus", gevondenSaus));
        return modelAndView;
    }

    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @GetMapping("alfabet")
    public ModelAndView alfabet() {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet);
    }

    private Stream<Saus> findByBeginNaamHelper(char letter) {
        return Arrays.stream(alleSauzen).filter(saus -> saus.getNaam().charAt(0) == letter);
    }

    @GetMapping("alfabet/{letter}")
    public ModelAndView findByBeginNaam(@PathVariable char letter) {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet)
                .addObject("sauzen", findByBeginNaamHelper(letter).iterator());
    }
}
