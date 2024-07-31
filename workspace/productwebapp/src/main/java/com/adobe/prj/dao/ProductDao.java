package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    void addProduct(Product p) throws PersistenceException;
    List<Product> getProducts();
}
