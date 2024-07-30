package com.adobe.prj.entity;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

@Table(name="books")
public class Book {
    String id;

    String title;

    double price;

    public Book() {
    }

    public Book(String id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    @Column(name="ISBN")
    public String getId() {
        return id;
    }

    @Column(name="BOOK_TITLE", type = "VARCHAR(100)")
    public String getTitle() {
        return title;
    }

    @Column(name="AMT", type = "NUMERIC(12,2)")
    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
