package com.adobe.prj.orderapp.api;

import com.adobe.prj.orderapp.entity.Product;
import com.adobe.prj.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final OrderService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    // GET http://localhost:8080/api/products/3
    @GetMapping("/{pid}")
    public  Product getProductById(@PathVariable("pid") int id) {
        return service.getProductById(id);
    }
}
