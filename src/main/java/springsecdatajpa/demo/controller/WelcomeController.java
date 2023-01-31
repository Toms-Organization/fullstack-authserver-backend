package springsecdatajpa.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WelcomeController {


    @GetMapping("/welcome")
    public String welcomeAll() {
        System.out.println("Are we here in welcome endpoint??");
        return "Welcome to this Open Endpoint";
    }


    @GetMapping("/welcomeTwo")
    public String welcomeAll2() {
        System.out.println("Are we here in welcome endpoint that is protected???");
        return "Welcome to this Open Endpoint that is protected";
    }

    @GetMapping("/openendpoint")
    public String openEndPoint() {
        System.out.println("AT OPEN ENDPOINT");
        return "AT OPEN ENDPOINT";
    }



}
