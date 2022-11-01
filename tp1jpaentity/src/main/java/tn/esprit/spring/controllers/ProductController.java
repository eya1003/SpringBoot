package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Product Management")
@RestController
@RequestMapping("product")
public class ProductController {

    @Operation(description = "Retrieve all products")
    @GetMapping("/getAll")
    public String SayWelcome() {
        return "Welcome to Spring Docs";
    }


}
