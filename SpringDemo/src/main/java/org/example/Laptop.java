package org.example;


import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {


    public Laptop() {
        System.out.println("Laptop created");
    }

    @Override
    public void compile() {
        System.out.println("Laptop compiled");
    }
}
