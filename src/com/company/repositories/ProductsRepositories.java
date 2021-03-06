package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.Position;
import com.company.entities.Products;
import com.company.repositories.interfaces.IProductsRepositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductsRepositories implements IProductsRepositories {
    private final IDBManager dbManager;

    public ProductsRepositories(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Products> showAllProducts() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Products> products = new ArrayList<>();

            while (resultSet.next()) {
                Products product = new Products(resultSet.getInt("id"),
                        resultSet.getString("product"),
                        resultSet.getInt("price"),
                        resultSet.getDate("delivery_date").toLocalDate(),
                        resultSet.getDate("expiration_date").toLocalDate());
                products.add(product);
            }

            return products;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Products> searchProductByName(String product) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE product =?");
            preparedStatement.setString(1, product);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Products> products = new ArrayList<>();

            while (resultSet.next()) {
                Products products1 = new Products(resultSet.getInt("id"),
                        resultSet.getString("product"),
                        resultSet.getInt("price"),
                        resultSet.getDate("delivery_date").toLocalDate(),
                        resultSet.getDate("expiration_date").toLocalDate());
                products.add(products1);
            }

            return products;

        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public Products getProductById(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return new Products(resultSet.getInt("id"),
                        resultSet.getString("product"),
                        resultSet.getInt("price"),
                        resultSet.getDate("delivery_date").toLocalDate(),
                        resultSet.getDate("expiration_date").toLocalDate());
            }

            return null;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addNewProduct(Products products) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products(product, price, delivery_date, expiration_date) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, products.getProduct());
            preparedStatement.setInt(2, products.getPrice());
            preparedStatement.setDate(3, Date.valueOf(products.getDelivery_date()));
            preparedStatement.setDate(4, Date.valueOf(products.getExpiration_date()));

            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeProduct(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id =?");
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
    public boolean deleteProductWithExpiredExpirationDate() {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products WHERE current_date > expiration_date");
            preparedStatement.execute();
            return true;
        }

        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
