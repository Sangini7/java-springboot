package com.sangini.SpringJDBCDemo.service;

import com.sangini.SpringJDBCDemo.Repository.StudentRepository;
import com.sangini.SpringJDBCDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
