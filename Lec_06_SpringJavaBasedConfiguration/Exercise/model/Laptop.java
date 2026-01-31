package model;

import org.springframework.stereotype.Component;

@Component("Laptop")
public class Laptop implements Computer {
    @Override
    public void compile() {
        System.out.println("Compiling from a Laptop");
    }
}
