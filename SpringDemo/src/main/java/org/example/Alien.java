package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
@Component

public class Alien {

    @Value("21")
    public int age;


    public Computer computer;

    public Alien() {
        System.out.println("Alien Constructor");
    }

//    @ConstructorProperties({"com", "age"})

    public Alien(   Computer  computer, int age) {
        this.computer = computer;
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }
    @Autowired
    @Qualifier("laptop")
    public void setComputer(Computer computer) {
        this.computer = computer;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void code(){
        System.out.println(this.getAge());
        System.out.println("Alien code");
        computer.compile();
    }
}
