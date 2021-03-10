package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Department;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeRepositories implements IEmployeeRepositories {
    private final IDBManager dbManager;

    public EmployeeRepositories(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    //Logic of all methods with using postgresql query
    @Override

    //to show all table We take it from from DB, create arraylist to save the employees and return this arraylist

    public ArrayList<Employee> showAllEmployee() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate("date_of_hiring").toLocalDate(),
                        resultSet.getString("position"),
                        resultSet.getString("department"));

                employees.add(employee);
            }

            return employees;

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override

    //Employee can have same name, because of this ArrayList was used to return list of all Employee with given name

    public ArrayList<Employee> searchEmployeeByName(String name) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name =?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate("dateOfHiring").toLocalDate(),
                        resultSet.getString("position"),
                        resultSet.getString("department"));

                employees.add(employee);
            }

            return employees;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override

    //Employee can have same department, because of this ArrayList was used to return list of all Employee with given department

    public ArrayList<Employee> searchEmployeeByDepartment(String department) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE department =?");
            preparedStatement.setString(1, department);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate("dateOfHiring").toLocalDate(),
                        resultSet.getString("position"),
                        resultSet.getString("department"));

                employees.add(employee);
            }

            return employees;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override

    //Employee can have same position, because of this ArrayList was used to return list of all Employee with given position

    public ArrayList<Employee> searchEmployeeByPosition(String position) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE position =?");
            preparedStatement.setString(1, position);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate("dateOfHiring").toLocalDate(),
                        resultSet.getString("position"),
                        resultSet.getString("department"));

                employees.add(employee);
            }

            return employees;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override

    //Employee have individual id, so Employee class was used to get only 1 result

    public Employee getEmployeeById(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDate("dateOfHiring").toLocalDate(),
                        resultSet.getString("position"),
                        resultSet.getString("department"));
            }

            return null;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override

    //method which connect employee and position table from DB to sum salary of all employees

    public int getSumOfSalaryOfAllEmployee() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(salary) FROM employee INNER JOIN position ON employee.position = position.position;");
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("sum");
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }

    @Override

    //boolean function with add department to DB, which return true if it was added, if not return false

    public boolean addNewEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee(name, surname, date_of_hiring, position, department) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setDate(3, Date.valueOf(employee.getDate_of_hiring()));
            preparedStatement.setString(4, employee.getPosition());
            preparedStatement.setString(5,employee.getDepartment());

            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override

    //deleting employee from DB with using id

    public boolean removeEmployee(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id =?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override

    //method which count amount(and return it) of employee in department which would be used for updating "employee quantity" in department table

    public int getEmployeeQuantity(String department) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(id) FROM employee WHERE department = '" + department +"'");
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count");
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }

        return 0;
    }

}
