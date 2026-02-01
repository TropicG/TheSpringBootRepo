package com.tropic.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("Student")
@Scope("prototype")
public class Student {
    private int rollno;
    private String name;
    private int marks;

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getRollno() {
        return rollno;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
