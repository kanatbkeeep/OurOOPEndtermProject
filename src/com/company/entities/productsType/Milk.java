package com.company.entities.productsType;

import com.company.entities.Products;

import java.time.LocalDate;

public class Milk extends Products {
    public Milk() {
    }

    public Milk(String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        super(product, price, delivery_date, expiration_date);
    }

    public Milk(int id, String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        super(id, product, price, delivery_date, expiration_date);
    }
}
