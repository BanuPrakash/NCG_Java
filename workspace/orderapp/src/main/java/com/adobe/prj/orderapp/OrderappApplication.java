package com.adobe.prj.orderapp;

import com.adobe.prj.orderapp.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderappApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderappApplication.class, args);

      //  Product p = new Product(0,"A", 45435.22);

//        Product p = new Product();
//        p.setName("A");
//        p.setPrice(3434);

        //Product p = Product.builder().name("A").price(3434).build();
    }

}
