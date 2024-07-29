package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

import java.lang.reflect.Method;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[4]; // Array of pointers to Product
        products[0] = new Mobile(34, "iPhone 15", 89_000.00, "5G"); //upcasting
        products[1] = new Tv(45, "Onida Thunder", 4000.00, "CRT");
        products[2] = new Tv(561, "Sony Bravia", 2_45_000.00, "OLED");
        products[3] = new Mobile(12, "Nokia", 4500.00, "4G");

        displayExpensiveProducts(products);
        displayProducts(products);
        displayProductsOCP(products);
    }

    // OCP
    private static void displayProductsOCP(Product[] products) {
        for (Product p : products) {
            Method[] methods = p.getClass().getMethods(); // methods from Mobile, Product + Object
            for(Method m : methods) {
                if (m.getName().startsWith("get")) {
                    try {
                        Object ret = m.invoke(p);
                        System.out.println(m.getName().substring(3).toUpperCase() + " : " + ret);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            System.out.println("*******");
        }
    }

    // Is this OCP ? NO
    private static void displayProducts(Product[] products) {
        for (Product p : products) {
            System.out.println(p.getName() + ", " + p.getPrice());
            if(p instanceof Mobile) {
                Mobile m = (Mobile) p; // downcasting
                System.out.println(m.getConnectivity());
            }
            if(p.getClass() == Tv.class) {
                Tv t = (Tv) p;
                System.out.println(t.getScreenType());
            }
        }
    }

    private static void displayExpensiveProducts(Product[] products) {
        for (Product p : products) {
            if(p.isExpensive()) { // polymorphic, dynamic binding
                System.out.println(p.getName() + " is expensive!!!");
            } else {
                System.out.println(p.getName() + " is not expensive!!!");
            }
        }
    }


}
