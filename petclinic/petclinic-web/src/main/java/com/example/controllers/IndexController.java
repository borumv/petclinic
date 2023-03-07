package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "index","", "index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/oups", "oups.html"})
    public String oupsHandler(Model model){
        return "notimplementedyet";
    }

}
