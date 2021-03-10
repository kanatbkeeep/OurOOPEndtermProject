package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

//Class which is connect to repository and myApplication, and return query result.

public class EmployeeController {
    private final IEmployeeRepositories employeeRepositories;

    public EmployeeController(IEmployeeRepositories employeeRepositories) {
        this.employeeRepositories = employeeRepositories;
    }

    public String showAllEmployee(){
        return employeeRepositories.showAllEmployee().toString();
    };

    public String searchEmployeeByName(String name){
        return employeeRepositories.searchEmployeeByName(name).toString();
    };

    public String searchEmployeeByDepartment(String department){
        return employeeRepositories.searchEmployeeByDepartment(department).toString();
    };

    public String searchEmployeeByPosition(String position){
        return employeeRepositories.searchEmployeeByPosition(position).toString();
    };

    public String getEmployeeById(int id){
        return employeeRepositories.getEmployeeById(id).toString();
    };

    public String getSumOfSalaryOfAllEmployee(){
        return Integer.toString(employeeRepositories.getSumOfSalaryOfAllEmployee());
    };

    public String addNewEmployee(Employee employee){
        boolean checkAdded = employeeRepositories.addNewEmployee((employee));

        if (checkAdded) return "****Employee was added to DB****";
        return "****Employee was NOT added to DB****";
    };

    public String removeEmployee(int id){
        boolean checkRemoved = employeeRepositories.removeEmployee(id);

        if(checkRemoved) return "****Employee was removed from DB****";
        return "****Employee was NOT removed from DB****";
    };

    public int getEmployeeQuantity(String department) {
        return employeeRepositories.getEmployeeQuantity(department);
    }
}
