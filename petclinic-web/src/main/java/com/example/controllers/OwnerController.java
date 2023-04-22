package com.example.controllers;

import com.example.models.Owner;
import com.example.services.OwnerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@RequestMapping("owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @InitBinder
    public void setAllowFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"/find"})
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result,
                                  Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        List<Owner> ownersResults = ownerService.findOwnersByLastNameLike("%" + owner.getLastName() + "%");

        // find owners by last name
        if (ownersResults.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }

        if (ownersResults.size() == 1) {
            // 1 owner found
            owner = ownersResults.iterator().next();
            return "redirect:/owners/" + owner.getId();
        }
        else {
            model.addAttribute("listOwners", ownersResults);
            return "owners/ownersList";
        }

    }
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner (@PathVariable("ownerId") Long id){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject("owner", ownerService.findById(id));
        return mav;
    }
}
