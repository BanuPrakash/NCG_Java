package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListClient {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(34, "iPhone 15", 89_000.00, "mobile"));
        products.add(new Product(45, "Onida Thunder", 4000.00, "tv"));
        products.add(new Product(561, "Sony Bravia", 2_45_000.00, "tv"));
        products.add(new Product(12, "Nokia", 4500.00, "mobile"));
        products.add(new Product(89, "Wacom", 5200.00, "computer"));

        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        for(Product p : products) {
            System.out.println(p); // toString
        }
    }
}
