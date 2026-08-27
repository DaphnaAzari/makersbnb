package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController

public class SpacesController {
    @Autowired
    SpaceRepository spaceRepository;

//GET "/spaces/new" retrieves the form

    @GetMapping("/spaces/new")
    public ModelAndView newSpaceForm() {
        Space space = new Space();
        ModelAndView newSpaceForm = new ModelAndView("spaces/new");
        newSpaceForm.addObject("space", space);
        return newSpaceForm;
    }
    //Submitting the form generates a POST "/spaces" request
    //The controller handles the request and redirects to GET "/spaces"

    @PostMapping("/spaces")
// Spring Boot uses the form data to create an instance of space
// which is then passed in as an arg here
    public RedirectView create(Space space) {
        spaceRepository.save(space);
        // assumes you already created a method to handle `GET "/spaces"`
        return new RedirectView("/spaces");
    }
}
