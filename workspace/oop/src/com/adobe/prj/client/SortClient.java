package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.util.Utility;

public class SortClient {
    public static void main(String[] args) {
        Product[] products = new Product[4]; // Array of pointers to Product
        products[0] = new Mobile(34, "iPhone 15", 89_000.00, "5G"); //upcasting
        products[1] = new Tv(45, "Onida Thunder", 4000.00, "CRT");
        products[2] = new Tv(561, "Sony Bravia", 2_45_000.00, "OLED");
        products[3] = new Mobile(12, "Nokia", 4500.00, "4G");

        Utility.sort(products);

        for(Product p : products) {
            System.out.println(p.getName() + ", " + p.getPrice());
        }
        String [] names = {"George", "Brad", "Angelina", "Scarlett", "DeNiro"};

        Utility.sort(names);

        for(String name : names) {
            System.out.println(name);
        }

    }
}
