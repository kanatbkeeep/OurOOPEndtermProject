package com.company.repositories.interfaces;

import com.company.entities.Department;

import java.util.ArrayList;

public interface IDepartmentRepositories {
    //methods list which id used for option in MyApplication class
    public ArrayList<Department> showAllDepartment();
    public Department getDepartmentByName(String department);
    public boolean addNewDepartment(Department department);
    public boolean removeDepartment(String department);
    public void updateEmployeeQuantity(int quantity, String department);
}
