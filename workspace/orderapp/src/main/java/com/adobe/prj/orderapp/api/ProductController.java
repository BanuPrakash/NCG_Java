package com.adobe.prj.orderapp.api;

import com.adobe.prj.orderapp.entity.Product;
import com.adobe.prj.orderapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final OrderService service;

    // GET http://localhost:8080/api/products
    // GET http://localhost:8080/api/products?low=5000&high=25000
    @GetMapping
    public List<Product> getProducts(@RequestParam(name = "low", defaultValue = "0.0") double low,
                                     @RequestParam(name = "high", defaultValue = "0.0") double high) {
        if(low == 0.0 && high == 0.0) {
            return service.getProducts();
        } else {
            return service.getByRange(low, high);
        }
    }

//    // GET http://localhost:8080/api/products/byRange?low=5000&high=25000
//    @GetMapping("/byRange")
//    public List<Product> getProducts(@RequestParam(name = "low", defaultValue = "0.0") double low,
//                                     @RequestParam(name = "high", defaultValue = "0.0") double high) {
//        return null;
//    }

    // GET http://localhost:8080/api/products/3
    @GetMapping("/{pid}")
    public  Product  getProductById(@PathVariable("pid") int id) throws EntityNotFoundException{
        return service.getProductById(id);
    }

    // POST http://localhost:8080/api/products
    // payload --> JSON / XML has to be  converted to Product
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED) //201
//    public Product addProduct(@RequestBody Product p) {
//        return service.addProduct(p);
//    }

    // Prefer ResponseEntity if STATUS CODE + ETAG +  additional info has to be sent along with payload
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product p) {
        return new ResponseEntity(service.addProduct(p), HttpStatus.CREATED);
    }

    // PUT http://localhost:8080/api/products/3
    // payload --> JSON / XML has to be  converted to Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product p) throws EntityNotFoundException{
        service.updateProduct(id, p.getPrice());
        return  service.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        // code to delete
        return  "Product deleted!!!";
    }
}
