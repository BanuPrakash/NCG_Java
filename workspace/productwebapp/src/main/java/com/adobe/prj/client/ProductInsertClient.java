package com.adobe.prj.client;

import com.adobe.prj.dao.PersistenceException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

import java.sql.SQLException;

public class ProductInsertClient {
    public static void main(String[] args) {
        Product p = new Product(0, "Wacom", 4500.00);
        ProductDao productDao = new ProductDaoJdbcImpl();
        try {
            productDao.addProduct(p);
            System.out.println("Product Added!!!");
        } catch (PersistenceException e) {
//            System.out.println(e.getMessage());
            e.printStackTrace(); // development stage
        }
    }
}
