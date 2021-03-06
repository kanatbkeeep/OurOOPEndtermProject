package com.company;

import com.company.controllers.DepartmentController;
import com.company.controllers.EmployeeController;
import com.company.controllers.PositionController;
import com.company.controllers.ProductsController;
import com.company.data.DBManager;
import com.company.data.interfaces.IDBManager;
import com.company.repositories.DepartmentRepositories;
import com.company.repositories.EmployeeRepositories;
import com.company.repositories.PositionRepositories;
import com.company.repositories.ProductsRepositories;
import com.company.repositories.interfaces.IDepartmentRepositories;
import com.company.repositories.interfaces.IEmployeeRepositories;
import com.company.repositories.interfaces.IPositionRepositories;
import com.company.repositories.interfaces.IProductsRepositories;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IDepartmentRepositories departmentRepositories = new DepartmentRepositories(dbManager);
        DepartmentController departmentController = new DepartmentController(departmentRepositories);
        IEmployeeRepositories employeeRepositories = new EmployeeRepositories(dbManager);
        EmployeeController employeeController = new EmployeeController(employeeRepositories);
        IPositionRepositories positionRepositories = new PositionRepositories(dbManager);
        PositionController positionController = new PositionController(positionRepositories);
        IProductsRepositories productsRepositories = new ProductsRepositories(dbManager);
        ProductsController productsController = new ProductsController(productsRepositories);
        MyApplication myApplication = new MyApplication(departmentController, employeeController, positionController, productsController);
        myApplication.start();
    }
}
