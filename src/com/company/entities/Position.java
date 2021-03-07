package com.company.entities;

public class Position {
    //creating var to position
    private String position;
    private int salary;

    //creating constructor
    public Position() {
    }

    public Position(String position, int salary) {
        setPosition(position);
        setSalary(salary);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //toString
    @Override
    public String toString() {
        return  "position = " + position + " | " +
                "salary = " + salary + "\n";
    }
}
