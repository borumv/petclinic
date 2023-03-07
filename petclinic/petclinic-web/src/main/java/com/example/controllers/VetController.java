package com.example.controllers;


import com.example.models.Vet;
import com.example.services.OwnerService;
import com.example.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@RequestMapping({"vets", "vets.html"})
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/", "/index", "index.html", ""})
    public String owners(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
