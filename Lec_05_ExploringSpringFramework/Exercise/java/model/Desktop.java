package model;

public class Desktop implements Computer {
    public Desktop() {
        System.out.println("Creating the Desktop");
    }

    @Override
    public void compile() {
        System.out.println("Compiling on a Desktop");
    }
}
