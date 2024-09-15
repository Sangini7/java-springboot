package com.sangini.app.service;

import com.sangini.app.model.Laptop;
import com.sangini.app.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    LaptopRepository laptopRepository;

    public LaptopRepository getLaptopRepository() {
        return laptopRepository;
    }

    @Autowired
    public void setLaptopRepository(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    public void addLaptop(Laptop laptop) {
        System.out.println("method add laptop");
        laptopRepository.saveLaptop(laptop);

    }

    public boolean isGoodForProg(Object obj) {
        return true;
    }
}
