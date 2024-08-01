package com.adobe.prj.orderapp.client;

import com.adobe.prj.orderapp.entity.Product;
import com.adobe.prj.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class ProductClient implements CommandLineRunner {
    private final OrderService service;

    @Override
    public void run(String... args) throws Exception {
       // addProduct();
      //  getProducts();
        getProductsByRange();
    }

    private void getProductsByRange() {
        List<Product> products = service.getByRange(500, 20000);
        for(Product p : products) {
            System.out.println(p);
        }
    }

    private void getProducts() {
        List<Product> products = service.getProducts();
        for(Product p : products) {
            System.out.println(p);
        }
    }
    private void addProduct() {
        Product p = Product.builder().name("LG AC").price(45000.00).quantity(100).build();
        service.addProduct(p);
    }
}
