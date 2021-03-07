package com.company.entities.productsType;

import com.company.entities.Products;

import java.time.LocalDate;

public class Household extends Products {
    public Household() {
    }

    public Household(String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        super(product, price, delivery_date, expiration_date);
    }

    public Household(int id, String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        super(id, product, price, delivery_date, expiration_date);
    }
}
