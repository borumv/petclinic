package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("pets")
@Controller
public class PetController {

    @RequestMapping({"/", "index.html", "index", ""})
    public String pets(){
        return "pets/index";
    }
}
