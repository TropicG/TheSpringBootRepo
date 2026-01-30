package com.tropic.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// with this annotation Spring IoC is informed that has to manage this object
// The spring IoC will take care for creation, assembling and managing the object
// Spring creates a BeanDefition for every class with @Component
@Component
public class Alien {

    // Since laptop is dependency for Alien, with this annotation Spring is informed
    // that has to search for laptop and inject into Alien
    @Autowired
    private Laptop laptop;

    public void code() {
        System.out.println("Coding");
        laptop.compile();
    }
}