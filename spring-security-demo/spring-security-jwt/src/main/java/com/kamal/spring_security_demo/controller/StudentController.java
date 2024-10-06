package com.kamal.spring_security_demo.controller;

import com.kamal.spring_security_demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Batman","Python"),
            new Student(2,"Captain","Java"),
            new Student(3,"Iron Man","JS")
    ));

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return this.students;
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "Student Added";
    }

}
