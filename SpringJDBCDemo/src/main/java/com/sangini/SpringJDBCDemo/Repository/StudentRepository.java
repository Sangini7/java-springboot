package com.sangini.SpringJDBCDemo.Repository;

import com.sangini.SpringJDBCDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student student) {
        System.out.println("Adding" + student);
        String sql = "insert into student (rollno, name, marks) values(?,?,?)";
        jdbc.update(sql, student.getRollNo(), student.getName(), student.getMarks());
    }

    public List<Student> findAll() {

        String sql = "select * from student";
        RowMapper<Student> rowMapper = (ResultSet rs, int rowNum) -> {

            Student student = new Student();
            student.setRollNo(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        };
        return jdbc.query(sql, rowMapper);

    }
}
