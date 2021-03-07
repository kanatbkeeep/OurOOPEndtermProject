package com.company.repositories.interfaces;

import com.company.entities.Employee;

import java.util.ArrayList;

public interface IEmployeeRepositories {
    //methods list which id used for option in MyApplication class
    public ArrayList<Employee> showAllEmployee();
    public ArrayList<Employee> searchEmployeeByName(String name);
    public ArrayList<Employee> searchEmployeeByDepartment(String department);
    public ArrayList<Employee> searchEmployeeByPosition(String position);
    public Employee getEmployeeById(int id);
    public int getSumOfSalaryOfAllEmployee();
    public boolean addNewEmployee(Employee employee);
    public boolean removeEmployee(int id);
    public int getEmployeeQuantity(String department);
}
