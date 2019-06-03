package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private final String message;

    @GetMapping("/")
    public String sayHello() {
        return this.message;
    }

    public WelcomeController(@Value("${welcome.message}") String message){
        this.message = message;

    }
}