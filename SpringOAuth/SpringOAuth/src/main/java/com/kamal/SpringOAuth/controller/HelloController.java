package com.kamal.SpringOAuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String root(){
        return "Visit /hello now";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello Kamal";
    }
}
