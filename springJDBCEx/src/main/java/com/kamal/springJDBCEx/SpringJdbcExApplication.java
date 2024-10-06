package com.kamal.springJDBCEx;

import com.kamal.springJDBCEx.model.Student;
import com.kamal.springJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import java.util.*;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student st = context.getBean(Student.class);
		st.setRollNo(119);
		st.setName("Kamal");
		st.setMarks(89);


		StudentService studentService = context.getBean(StudentService.class);

		try{
			studentService.addStudent(st);
		}
		catch (DuplicateKeyException dup){
			System.out.println("Record with roll no already exists.");
			System.out.println(dup.getMessage());
		}
		catch (Exception e){
			System.out.println(e);
		}

		List<Student> students = studentService.getStudents();
		for(Student s: students){
			System.out.println(s);
		}
	}

}
