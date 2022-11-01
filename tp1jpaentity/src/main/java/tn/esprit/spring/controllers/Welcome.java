package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Welcome Management")
@RestController
@RequestMapping("welcome")
public class Welcome {

    @GetMapping("/hello")
    public String SayWelcome() {
        return "Welcome to Spring Docs";
    }



}
