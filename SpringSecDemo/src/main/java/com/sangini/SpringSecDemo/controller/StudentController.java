package com.sangini.SpringSecDemo.controller;

import com.sangini.SpringSecDemo.Student;
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

    List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1, "Sangini", "CP"),
                    new Student(1, "Samyak", "CP2"))
    );

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }
    @GetMapping("csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("student")
    public void addStudent(@RequestBody Student s) {
        students.add(s);
    }

}
