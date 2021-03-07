package com.company.entities.productsType;

import com.company.entities.Products;

import java.time.LocalDate;

public class Flour extends Products {
    public Flour() {
    }

    public Flour(String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        super(product, price, delivery_date, expiration_date);
    }

    public Flour(int id, String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        super(id, product, price, delivery_date, expiration_date);
    }
}
