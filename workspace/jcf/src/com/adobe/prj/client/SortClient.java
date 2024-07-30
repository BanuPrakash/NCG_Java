package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.Arrays;
import java.util.Comparator;

public class SortClient {
    public static void main(String[] args) {
        String [] names = {"Ross", "Chandler", "Rachel", "Joey", "Phoebe"};
        Arrays.sort(names);
        for(String name : names) {
            System.out.println(name);
        }

        System.out.println("*****");
        // Comparator
        Arrays.sort(names, (o1, o2) ->  o1.length() - o2.length());
        for(String name : names) {
            System.out.println(name);
        }

        System.out.println("*****");
        Product[] products = new Product[5];
        products[0] = new Product(34, "iPhone 15", 89_000.00, "mobile"); //upcasting
        products[1] = new Product(45, "Onida Thunder", 4000.00, "tv");
        products[2] = new Product(561, "Sony Bravia", 2_45_000.00, "tv");
        products[3] = new Product(12, "Nokia", 4500.00, "mobile");
        products[4] = new Product(89, "Wacom", 5200.00, "computer");

        Arrays.sort(products);
        for(Product p : products) {
            System.out.println(p); // toString
        }

        System.out.println("*****");
//        Arrays.sort(products, (p1, p2) -> (int)(p1.getPrice() - p2.getPrice()));
        Arrays.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        for(Product p : products) {
            System.out.println(p); // toString
        }
    }
}
