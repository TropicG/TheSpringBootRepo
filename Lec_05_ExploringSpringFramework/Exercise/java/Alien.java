import model.Computer;

import java.beans.ConstructorProperties;

public class Alien {
    private Computer com;
    private int age;

    // this annotation is used, so that Spring can see which value has to be assing to which data-member
    @ConstructorProperties({"age", "com"})
    public Alien(int age, Computer com) {
        this.age = age;
        this.com = com;
    }

    public void code() {
        System.out.println("Coding");
        com.compile();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public Computer getLaptop() {
        return com;
    }
}
