package com.tropic.model.alien;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    private int carid;
    private String model;

    public Car() {}

    public Car(int carid, String model) {
        this.carid = carid;
        this.model = model;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
