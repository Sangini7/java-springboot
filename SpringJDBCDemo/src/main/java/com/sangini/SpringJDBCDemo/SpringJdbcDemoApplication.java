package com.sangini.SpringJDBCDemo;

import com.sangini.SpringJDBCDemo.model.Student;
import com.sangini.SpringJDBCDemo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(SpringJdbcDemoApplication.class, args);
        Student student= context.getBean( Student.class);
        StudentService studentService= context.getBean( StudentService.class);
        student.setName("Sangini");
        student.setMarks(100);
        student.setRollNo(4);
        studentService.addStudent(student);
        List<Student> studentList= studentService.getStudents();
        System.out.println(studentList);
    }

}
