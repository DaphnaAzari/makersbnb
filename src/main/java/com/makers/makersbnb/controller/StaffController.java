package com.makers.makersbnb.controller;

import com.makers.makersbnb.repository.StaffRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


//public class StaffController {
//    @GetMapping("/team")
//    public String teamPage(){
//        return "Toby, Katerina, Sandy";
//    }
   @RestController
   public class StaffController {
       StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping("/team")
    public ModelAndView teamPage() {
        ModelAndView modelAndView = new ModelAndView("/team");
        String team = "Toby, Katerina, Sandy";
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    @GetMapping("/team1")
    public ModelAndView teamOnePage() {
        ModelAndView modelAndView = new ModelAndView("/team1");
        modelAndView.addObject("staff1", staffRepository.findAll());
        return modelAndView;
    }
}
