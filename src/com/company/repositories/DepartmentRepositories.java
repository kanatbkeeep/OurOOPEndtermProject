package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Department;
import com.company.repositories.interfaces.IDepartmentRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DepartmentRepositories implements IDepartmentRepositories {
    private final IDBManager dbManager;

    public DepartmentRepositories(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    //Logic of all methods with using postgresql query
    @Override
    public ArrayList<Department> showAllDepartment() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM department");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Department> departments = new ArrayList<>();

            while (resultSet.next()) {
                Department department = new Department(resultSet.getString("department"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getInt("employee_quantity"));

                departments.add(department);
            }

            return departments;

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public Department getDepartmentByName(String department) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM department WHERE department =?");
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();

            return new Department(resultSet.getString("department"),
                    resultSet.getString("address"),
                    resultSet.getString("city"),
                    resultSet.getInt("employee_quantity"));

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addNewDepartment(Department department) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO department(department, address, city, employee_quantity) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, department.getDepartment());
            preparedStatement.setString(2, department.getAddress());
            preparedStatement.setString(3, department.getCity());
            preparedStatement.setInt(4, department.getEmployee_quantity());
            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeDepartment(String department) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM department WHERE department =?");
            preparedStatement.setString(1, department);
            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateEmployeeQuantity(int quantity, String department) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE department set employee_quantity=? WHERE department =?");
            preparedStatement.setInt(1, quantity);
            preparedStatement.setString(2, department);
            preparedStatement.execute();
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
