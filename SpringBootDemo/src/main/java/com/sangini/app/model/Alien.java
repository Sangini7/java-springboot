package com.sangini.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private int age;
    private Computer computer;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Computer getComputer() {
        return computer;
    }

    @Autowired
    public void setComputer(Computer computer) {
        this.computer = computer;
    }


    void code() {
        computer.compile();
    }
}
