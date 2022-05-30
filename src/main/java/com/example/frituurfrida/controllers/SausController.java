package com.example.frituurfrida.controllers;

import com.example.frituurfrida.domain.Saus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.List;

@Controller
public class SausController {
    private final Saus[] alleSauzen = {
            new Saus(1,"cocktail", new String[] {"mayonaise", "ketchup", "whisky"}),
            new Saus(2,"mayonaise", new String[] {"olie", "eidooiers", "mosterd", "azijn"}),
            new Saus(3,"mosterd", new String[] {"mosterdzaad", "water", "zout", "azijn"}),
            new Saus(4,"tartare", new String[] {"eitjes", "augurk", "kappertjes", "mayonaise", "verse kruiden"}),
            new Saus(5,"vinaigrette", new String[] {"wijnazijn", "mosterd", "olie"})
    };

    @GetMapping("/sauzen")
    private ModelAndView findAll(){
        return new ModelAndView("sauzen", "alleSauzen", alleSauzen);
    }
}
