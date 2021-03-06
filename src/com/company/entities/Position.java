package com.company.entities;

public class Position {
    private String position;
    private int salary;

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

    @Override
    public String toString() {
        return  "position = " + position + " | " +
                "salary = " + salary + "\n";
    }
}
