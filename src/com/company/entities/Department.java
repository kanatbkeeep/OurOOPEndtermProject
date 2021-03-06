package com.company.entities;

public class Department {
    private String department;
    private String address;
    private String city;
    private int employee_quantity;

    public Department() {
    }

    public Department(String department, String address, String city) {
        setDepartment(department);
        setAddress(address);
        setCity(city);
    }

    public Department(String department, String address, String city, int employee_quantity) {
        setDepartment(department);
        setAddress(address);
        setCity(city);
        setEmployee_quantity(employee_quantity);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getEmployee_quantity() {
        return employee_quantity;
    }

    public void setEmployee_quantity(int employee_quantity) {
        this.employee_quantity = employee_quantity;
    }

    @Override
    public String toString() {
        return  "department = " + department + " | " +
                "address = " + address + " | " +
                "city = " + city + " | " +
                "employee quantity = " + employee_quantity + "\n";
    }
}
