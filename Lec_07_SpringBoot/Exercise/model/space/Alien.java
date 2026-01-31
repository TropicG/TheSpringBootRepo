package model.space;

import model.pc.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Alien")
public class Alien {

    @Value("21")
    private int age;

    @Autowired
    @Qualifier("Desktop")
    private Computer com;

    public void coding() {
        System.out.println("coding");
        com.compile();
    }
}
