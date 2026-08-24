package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// tell Spring Boot this class is a controller
@RestController
public class StaticPageController {
    // tell Spring Boot this method handles the 'GET "/"' request
    @GetMapping("/")
    public String landingPage() {
        return "Welcome to MakersBnB!";
    }
    @GetMapping("/contactus")
    public String contactPage(){
        return "makersbnb@gmail.com";
    }
}
