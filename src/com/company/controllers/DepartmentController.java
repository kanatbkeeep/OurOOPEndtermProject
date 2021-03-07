package com.company.controllers;

import com.company.entities.Department;
import com.company.repositories.interfaces.IDepartmentRepositories;

//Class which is connect to repository and myApplication, and return query result

public class DepartmentController {
    private final IDepartmentRepositories departmentRepositories;

    public DepartmentController(IDepartmentRepositories departmentRepositories) {
        this.departmentRepositories = departmentRepositories;
    }

    public String showAllDepartment(){
        return departmentRepositories.showAllDepartment().toString();
    };

    public String getDepartmentByName(String department){
        return departmentRepositories.getDepartmentByName(department).toString();
    };

    public String addNewDepartment(Department department){
        boolean checkAdded = departmentRepositories.addNewDepartment(department);

        if (checkAdded) return "****Department was added to DB****";
        return "****Department was NOT added to DB****";
    };

    public String removeDepartment(String department){
        boolean checkRemoved = departmentRepositories.removeDepartment(department);

        if (checkRemoved) return "****Department was removed from DB****";
        return "****Department was NOT removed from DB****";
    };

    public void updateEmployeeQuantity(int quantity, String department) {
        departmentRepositories.updateEmployeeQuantity(quantity, department);
    }
}
