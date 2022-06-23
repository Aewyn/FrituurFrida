package com.example.frituurfrida.controllers;

import com.example.frituurfrida.domain.Snack;
import com.example.frituurfrida.repositories.SnackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("snacks")
public class SnackController {
//    private final SnackRepository snackRepository;
//
//    public SnackController(SnackRepository snackRepository){
//        this.snackRepository = snackRepository;
//    }

//    @GetMapping
//    private ModelAndView findAll() {
//        return new ModelAndView("snacks", "alleSnacks", snackRepository.findAll());
//    }
}
