package com.company.entities;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private LocalDate date_of_hiring;
    private String position;
    private String department;

    public Employee() {
    }

    public Employee(String name, String surname, LocalDate date_of_hiring, String position, String department) {
        setName(name);
        setSurname(surname);
        setDate_of_hiring(date_of_hiring);
        setPosition(position);
        setDepartment(department);
    }

    public Employee(int id, String name, String surname, LocalDate date_of_hiring, String position, String department) {
        setId(id);
        setName(name);
        setSurname(surname);
        setDate_of_hiring(date_of_hiring);
        setPosition(position);
        setDepartment(department);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDate_of_hiring() {
        return date_of_hiring;
    }

    public void setDate_of_hiring(LocalDate date_of_hiring) {
        this.date_of_hiring = date_of_hiring;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return  "id = " + id + " | " +
                "name = " + name + " | " +
                "surname = " + surname + " | " +
                "date_of_hiring = " + date_of_hiring + " | " +
                "position = " + position + " | " +
                "department = " + department + "\n";
    }
}
