package com.company.entities;

import java.time.LocalDate;

public class Products {
    //creating var to products
    private int id;
    private String product;
    private int price;
    private LocalDate delivery_date;
    private LocalDate expiration_date;

    //creating constructor, also one should be without id, because it automatically generate in DB
    public Products() {
    }

    public Products(String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        setProduct(product);
        setPrice(price);
        setDelivery_date(delivery_date);
        setExpiration_date(expiration_date);
    }

    public Products(int id, String product, int price, LocalDate delivery_date, LocalDate expiration_date) {
        setId(id);
        setProduct(product);
        setPrice(price);
        setDelivery_date(delivery_date);
        setExpiration_date(expiration_date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }

    public LocalDate getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(LocalDate expiration_date) {
        this.expiration_date = expiration_date;
    }

    @Override
    public String toString() {
        return  "id = " + id + " | " +
                "product = " + product + " | " +
                "price = " + price + " | " +
                "delivery date = " + delivery_date + " | " +
                "expiration date = " + expiration_date + "\n";
    }
}
