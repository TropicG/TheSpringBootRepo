package com.tropic;

import com.tropic.model.Student;
import com.tropic.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringJdbcDemoApplication.class, args);


		Student student = applicationContext.getBean(Student.class);

		student.setName("TropicGamerMC");
		student.setRollno(82129);
		student.setMarks(4);

		StudentService studentService = applicationContext.getBean(StudentService.class);
		studentService.addStudent(student);

		List<Student> students = studentService.getStudents();
		for(Student student1 : students) {
			System.out.println(student1);
		}
	}

}
