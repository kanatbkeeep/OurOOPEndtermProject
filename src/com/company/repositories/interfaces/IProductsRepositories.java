package com.company.repositories.interfaces;

import com.company.entities.Products;

import java.util.ArrayList;

public interface IProductsRepositories {
    //methods list which id used for option in MyApplication class
    public ArrayList<Products> showAllProducts();
    public ArrayList<Products> searchProductByName(String product);
    public Products getProductById(int id);
    public boolean addNewProduct(Products products);
    public boolean removeProduct(int id);
    public boolean deleteProductWithExpiredExpirationDate();
}
