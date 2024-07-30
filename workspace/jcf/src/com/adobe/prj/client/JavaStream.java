package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(34, "iPhone 15", 89_000.00, "mobile"));
        products.add(new Product(45, "Onida Thunder", 4000.00, "tv"));
        products.add(new Product(561, "Sony Bravia", 2_45_000.00, "tv"));
        products.add(new Product(12, "Nokia", 4500.00, "mobile"));
        products.add(new Product(89, "Wacom", 5200.00, "computer"));

        List<String> names = products.stream().map(p -> p.getName()).collect(Collectors.toList());
        System.out.println(names);

        // get total of all mobiles



    }
}
