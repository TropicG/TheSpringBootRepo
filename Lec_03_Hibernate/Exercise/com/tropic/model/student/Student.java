package com.tropic.model.student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// indicates to Hibernate that this class corresponds to a database table (probably Student in the database)
@Entity
public class Student {

    // indicates that this data member is the PK of the table
    @Id
    private int rollno;

    private String sname;
    private int sage;

    public Student() {}

    public Student(int rollNo, String sname, int sAge){
        this.rollno = rollNo;
        this.sname = sname;
        this.sage = sAge;
    }

    public Student(StudentBuilder studentBuilder) {
        this.rollno = studentBuilder.rollNo;
        this.sname = studentBuilder.sname;
        this.sage = studentBuilder.sAge;
    }

    public int getRollNo() {
        return rollno;
    }

    public String getSname() {
        return sname;
    }

    public int getsAge() {
        return sage;
    }

    public void setRollNo(int rollNo) {
        this.rollno = rollNo;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setsAge(int sAge) {
        this.sage = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollno +
                ", sname='" + sname + '\'' +
                ", sAge=" + sage +
                '}';
    }

    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private int rollNo;
        private String sname;
        private int sAge;

        public StudentBuilder() {
        }

        public StudentBuilder setRollNo(int rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public StudentBuilder setSname(String sname) {
            this.sname = sname;
            return this;
        }

        public StudentBuilder setsAge(int sAge) {
            this.sAge = sAge;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

}
