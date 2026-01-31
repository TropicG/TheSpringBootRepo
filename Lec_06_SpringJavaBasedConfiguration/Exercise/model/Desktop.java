package model;

import org.springframework.stereotype.Component;

@Component("Desktop")
public class Desktop implements Computer {
    @Override
    public void compile() {
        System.out.println("Compiling on a Desktop");
    }
}
