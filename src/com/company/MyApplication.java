package com.company;

import com.company.controllers.DepartmentController;
import com.company.controllers.EmployeeController;
import com.company.controllers.PositionController;
import com.company.controllers.ProductsController;
import com.company.entities.Department;
import com.company.entities.Employee;
import com.company.entities.Position;
import com.company.entities.Products;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class MyApplication {
    //create new var to connect it to controllers class
    private Scanner scanner;
    private DepartmentController departmentController;
    private EmployeeController employeeController;
    private PositionController positionController;
    private ProductsController productsController;

    //creating constructor
    public MyApplication(DepartmentController departmentController, EmployeeController employeeController, PositionController positionController, ProductsController productsController) {
        scanner = new Scanner(System.in);
        this.departmentController = departmentController;
        this.employeeController = employeeController;
        this.positionController = positionController;
        this.productsController = productsController;
    }

    //function start
    public void start() {
        //options list
        while (true) {
            System.out.println("""
                            Choose one option:
                            1)Products Controller
                            2)Employee Controller
                            3)Position Controller
                            4)Department Controller
                            """
            );

            int choice = scanner.nextInt();

            System.out.println("**********************************************");

            if (choice == 1) {
                System.out.println("""
                            Choose one option:
                            1)Show All Products
                            2)Search Product By Name
                            3)Get Product By Id
                            4)Add New Product
                            5)Remove Product
                            6)Delete Product With Expired Expiration Date
                            """
                );

                int choice1 = scanner.nextInt();

                if (choice1 == 1) showAllProductsMenu();
                else if (choice1 == 2) searchProductByNameMenu();
                else if (choice1 == 3) getProductByIdMenu();
                else if (choice1 == 4) addNewProductMenu();
                else if (choice1 == 5) removeProductMenu();
                else if (choice1 == 6) deleteProductWithExpiredExpirationDateMenu();
                else break;

            }

            else if (choice == 2) {
                System.out.println("""
                            Choose one option:
                            1)show All Employee
                            2)search Employee By Name
                            3)search Employee By Department
                            4)search Employee By Position
                            5)get Employee By Id
                            6)get Sum Of Salary Of All Employee
                            7)add New Employee
                            8)remove Employee
                            """
                );

                int choice1 = scanner.nextInt();

                if (choice1 == 1) showAllEmployeeMenu();
                else if (choice1 == 2) searchEmployeeByNameMenu();
                else if (choice1 == 3) searchEmployeeByDepartmentMenu();
                else if (choice1 == 4) searchEmployeeByPositionMenu();
                else if (choice1 == 5) getEmployeeByIdMenu();
                else if (choice1 == 6) getSumOfSalaryOfAllEmployeeMenu();
                else if (choice1 == 7) addNewEmployeeMenu();
                else if (choice1 == 8) removeEmployeeMenu();
                else break;
            }

            else if (choice == 3) {
                System.out.println("""
                            Choose one option:
                            1)show All Position
                            2)add New Position
                            3)remove Position
                            """
                );

                int choice1 = scanner.nextInt();

                if (choice1 == 1) showAllPositionMenu();
                else if (choice1 == 2) addNewPositionMenu();
                else if (choice1 == 3) removePositionMenu();
                else break;
            }

            else if (choice == 4) {
                System.out.println("""
                            Choose one option:
                            1)show All Department
                            2)get Department By Name
                            3)add New Department
                            4)remove Department
                            """
                );

                int choice1 = scanner.nextInt();

                if (choice1 == 1) showAllDepartmentMenu();
                else if (choice1 == 2) getDepartmentByNameMenu();
                else if (choice1 == 3) addNewDepartmentMenu();
                else if (choice1 == 4) removeDepartmentMenu();
                else break;
            }

            else break;

            System.out.println("**********************************************");
        }
    }

    //-------------------------------------------EMPLOYEE-MENU-----------------------------------------------

    public void showAllEmployeeMenu() {
        System.out.println(employeeController.showAllEmployee());
    }

    public void searchEmployeeByNameMenu() {
        System.out.println("White employee's name to search:");
        String name = scanner.next();
        System.out.println(employeeController.searchEmployeeByName(name));
    }

    public void searchEmployeeByDepartmentMenu() {
        System.out.println("White employee's department to search:");
        String department = scanner.next();
        System.out.println(employeeController.searchEmployeeByName(department));
    }

    public void searchEmployeeByPositionMenu() {
        System.out.println("White employee's position to search:");
        String position = scanner.next();
        System.out.println(employeeController.searchEmployeeByName(position));
    }

    public void getEmployeeByIdMenu() {
        System.out.println("White employee's id to search:");
        int id = scanner.nextInt();
        System.out.println(employeeController.getEmployeeById(id));
    }

    public void getSumOfSalaryOfAllEmployeeMenu() {
        System.out.println(employeeController.getSumOfSalaryOfAllEmployee());
    }

    public void addNewEmployeeMenu() {
        System.out.println("White employee's name to add it to DB:");
        String name = scanner.next();
        System.out.println("White employee's surname to add it to DB:");
        String surname = scanner.next();
        System.out.println("White employee's hiring date to add it to DB ( pattern: yyyy-mm-dd ):");
        String date_of_hiring = scanner.next();
        System.out.println("White employee's position to add it to DB:");
        String position = scanner.next();
        System.out.println("White employee's department to add it to DB:");
        String department = scanner.next();
        Employee employee = new Employee(name, surname, LocalDate.parse(date_of_hiring), position, department);
        System.out.println(employeeController.addNewEmployee(employee));

        //updating employee quantity in department everytime when new employee is added
        departmentController.updateEmployeeQuantity(employeeController.getEmployeeQuantity(department), department);
    }

    public void removeEmployeeMenu() {
        System.out.println("White employee's id to remove employee from DB:");
        int id = scanner.nextInt();
        System.out.println("White employee's department to remove employee from DB:");
        String department = scanner.next();
        System.out.println(employeeController.removeEmployee(id));
        departmentController.updateEmployeeQuantity(employeeController.getEmployeeQuantity(department), department);
    }

    //-------------------------------------------PRODUCTS-MENU-----------------------------------------------

    public void showAllProductsMenu() {
        System.out.println(productsController.showAllProducts());
    }

    public void searchProductByNameMenu() {
        System.out.println("White product's name to search:");
        String product = scanner.next();
        System.out.println(productsController.searchProductByName(product));
    }

    public void getProductByIdMenu() {
        System.out.println("White product's id to search:");
        int id = scanner.nextInt();
        System.out.println(productsController.getProductById(id));
    }

    public void addNewProductMenu() {
        System.out.println("White product's name to add it to DB:");
        String product = scanner.next();
        System.out.println("White product's price to add it to DB:");
        int price = scanner.nextInt();
        LocalDate delivery_date = LocalDate.now();
        System.out.println("White product's expiration date to add it to DB ( pattern: yyyy-mm-dd ):");
        String expiration_date = scanner.next();
        Products products = new Products(product, price, delivery_date, LocalDate.parse(expiration_date));
        System.out.println(productsController.addNewProduct(products));

    }

    public void removeProductMenu() {
        System.out.println("White product's id to remove product from DB:");
        int id = scanner.nextInt();
        System.out.println(productsController.removeProduct(id));
    }

    public void deleteProductWithExpiredExpirationDateMenu() {
        System.out.println(productsController.deleteProductWithExpiredExpirationDate());
    }

    //-------------------------------------------DEPARTMENT-MENU-----------------------------------------------

    public void showAllDepartmentMenu() {
        System.out.println(departmentController.showAllDepartment());
    }

    public void getDepartmentByNameMenu() {
        System.out.println("White department's name to search:");
        String department = scanner.next();
        System.out.println(departmentController.getDepartmentByName(department));
    }

    public void addNewDepartmentMenu() {
        System.out.println("White department's name to add it to DB:");
        String department = scanner.next();
        System.out.println("White department's address to add it to DB:");
        String address = scanner.next();
        System.out.println("White department's city to add it to DB:");
        String city = scanner.next();
        Department department1 = new Department(department, address, city);
        System.out.println(departmentController.addNewDepartment(department1));
    }

    public void removeDepartmentMenu() {
        System.out.println("White department's name to remove it from DB:");
        String department = scanner.next();
        System.out.println(departmentController.removeDepartment(department));
    }

    //-------------------------------------------POSITION-MENU-----------------------------------------------

    public void showAllPositionMenu() {
        System.out.println(positionController.showAllPosition());
    }

    public void addNewPositionMenu() {
        System.out.println("White position's name to add it to DB:");
        String position = scanner.next();
        System.out.println("White position's salary to add it to DB:");
        int salary = scanner.nextInt();
        Position position1 = new Position(position, salary);
        System.out.println(positionController.addNewPosition(position1));
    }

    public void removePositionMenu() {
        System.out.println("White position's name to remove it from DB");
        String position = scanner.next();
        System.out.println(positionController.removePosition(position));
    }
}
