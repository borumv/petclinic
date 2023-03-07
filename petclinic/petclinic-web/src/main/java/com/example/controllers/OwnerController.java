package com.example.controllers;

import com.example.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @RequestMapping({"/", "/index", "index.html", ""})
    public String owners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        System.out.println("tralala");
        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String findOwners(Model model){
        return "notimplementedyet";
    }
}
