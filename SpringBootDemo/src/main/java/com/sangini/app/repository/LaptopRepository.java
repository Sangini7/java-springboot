package com.sangini.app.repository;

import com.sangini.app.model.Laptop;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    public void saveLaptop(Laptop laptop) {
        System.out.println("saved in DB");
    }
}
