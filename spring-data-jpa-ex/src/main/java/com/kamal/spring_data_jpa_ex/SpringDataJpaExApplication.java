package com.kamal.spring_data_jpa_ex;

import com.kamal.spring_data_jpa_ex.model.Student;
import com.kamal.spring_data_jpa_ex.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;


@SpringBootApplication
public class SpringDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringDataJpaExApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);


		Student  s1 =  context.getBean(Student.class);
		Student  s2 =  context.getBean(Student.class);
		Student  s3 =  context.getBean(Student.class);

		s1.setRollNo(4);
		s1.setName("Superman");
		s1.setMarks(88);

		s2.setRollNo(5);
		s2.setName("Doctor Strange");
		s2.setMarks(84);

		s3.setRollNo(6);
		s3.setName("Venom");
		s3.setMarks(95);

		try{
//			repo.save(s2);
//			repo.save(s3);

			Optional<Student> optionalStudent = repo.findById(4);
			System.out.println(optionalStudent.orElse(new Student()));
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}
