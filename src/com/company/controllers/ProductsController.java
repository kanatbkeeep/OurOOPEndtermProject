package com.company.controllers;

import com.company.entities.Products;
import com.company.repositories.interfaces.IProductsRepositories;

public class ProductsController {
    private final IProductsRepositories productsRepositories;

    public ProductsController(IProductsRepositories productsRepositories) {
        this.productsRepositories = productsRepositories;
    }

    public String showAllProducts(){
        return productsRepositories.showAllProducts().toString();
    };

    public String searchProductByName(String product){
        return productsRepositories.searchProductByName(product).toString();
    };

    public String getProductById(int id){
        return productsRepositories.getProductById(id).toString();
    };

    public String addNewProduct(Products products){
        boolean checkAdded = productsRepositories.addNewProduct(products);

        if (checkAdded) return "****Product was added to DB****";
        return "****Product was NOT added to DB****";
    };

    public String removeProduct(int id){
        boolean checkRemoved = productsRepositories.removeProduct(id);

        if (checkRemoved) return "****Product was removed from DB****";
        return "****Product was NOT removed from DB****";
    };

    public String deleteProductWithExpiredExpirationDate(){
        boolean checkRemoved = productsRepositories.deleteProductWithExpiredExpirationDate();
        if (checkRemoved) return "****Product was removed from DB****";
        return "****Product was NOT removed from DB****";
    };
}
