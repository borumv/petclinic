package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnerController {

    @RequestMapping({"/", "/index", "index.html", ""})
    public String owners(){
        System.out.println("tralala");
        return "owners/index";
    }
}
