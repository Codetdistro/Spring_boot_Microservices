package com.example.secondservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class Controller {

    @GetMapping("/message")
    public String test(){
        return "Hi! this is second service";
    }
}
