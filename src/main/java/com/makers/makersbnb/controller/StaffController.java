package com.makers.makersbnb.controller;

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
    @GetMapping("/team")
    public ModelAndView teamPage() {
        ModelAndView modelAndView = new ModelAndView("/team");
        String team = "Toby, Katerina, Sandy";
        modelAndView.addObject("team", team);
        return modelAndView;
    }
}
