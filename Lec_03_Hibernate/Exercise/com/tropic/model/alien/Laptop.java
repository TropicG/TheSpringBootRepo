package com.tropic.model.alien;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private int id;
    private String brand;
    private String model;
    private int ram;

    @ManyToOne
    private Alien alien;

    public Laptop() {}

    public Laptop(int id, String brand, String model, int ram) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}
