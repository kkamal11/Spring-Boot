package com.kamal.spring_security_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String test(){
        return "Hello there....";
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request){
        return "I am Kamal.... " + request.getSession().getId();
    }
}
