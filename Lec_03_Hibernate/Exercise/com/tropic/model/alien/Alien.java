package com.tropic.model.alien;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;

    @OneToOne
    private Car car;

    @OneToMany(mappedBy = "alien")
    // We can use @OneToMany(fetch = FetchType.EAGER) to perform eager fetch 
    // In order to create ManyToMany relationship used @ManyToMany
    private List<Laptop> laptops;

   // @OneToOne
   // private Laptop laptop;

    // using @Table(name="") to a class will make a table with the arg given to the annotation
    // using @Colum(name="") to a data member will make the column name to be changed in the database
    // using @Transient to a data member it would not appear in the database

    public Alien() {}

    public Alien(AlienBuilder alienBuilder) {
        this.aid = alienBuilder.aid;
        this.aname = alienBuilder.aname;
        this.tech = alienBuilder.tech;
        this.car = alienBuilder.car;
        this.laptops = alienBuilder.laptops;
    }

    public static AlienBuilder builder() {
        return new AlienBuilder();
    }

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptop(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public int getAid() {
        return aid;
    }

    public String getTech() {
        return tech;
    }

    public String getAname() {
        return aname;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", car=" + car +
                '}';
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public static class AlienBuilder {
        private int aid;
        private String aname;
        private String tech;
        private Laptop laptop;
        private Car car;
        private List<Laptop> laptops;

        public AlienBuilder() {
        }

        public AlienBuilder setAid(int aid) {
            this.aid = aid;
            return this;
        }

        public AlienBuilder setTech(String tech) {
            this.tech = tech;
            return this;
        }

        public AlienBuilder setAname(String aname) {
            this.aname = aname;
            return this;
        }

        public AlienBuilder setLaptops(List<Laptop> laptops) {
            this.laptops = laptops;
            return this;
        }

        public AlienBuilder setCar(Car car) {
            this.car = car;
            return this;
        }

        public Alien build() {
            return new Alien(this);
        }
    }
}
