package com.kamal.springJDBCEx.service;

import com.kamal.springJDBCEx.model.Student;
import com.kamal.springJDBCEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

//@Component
@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student st){
        System.out.println("Going to add student in db");
        repo.save(st);
    }

    public List<Student> getStudents(){
        return repo.findAll();
    }
}
