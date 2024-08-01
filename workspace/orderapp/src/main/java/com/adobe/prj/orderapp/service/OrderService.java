package com.adobe.prj.orderapp.service;

import com.adobe.prj.orderapp.dao.CustomerDao;
import com.adobe.prj.orderapp.dao.ProductDao;
import com.adobe.prj.orderapp.entity.Customer;
import com.adobe.prj.orderapp.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductDao productDao;
    private final CustomerDao customerDao; // generated implementation class by Spring Data Jpa is wired

    public List<Product> getProducts() {
        return productDao.findAll();
    }

    public Product addProduct(Product p) {
        return productDao.save(p);
    }

    public Product getProductById(int id) {
        Optional<Product> opt = productDao.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        return  null;
    }

    public Customer saveCustomer(Customer c) {
        return  customerDao.save(c);
    }

    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }
}
