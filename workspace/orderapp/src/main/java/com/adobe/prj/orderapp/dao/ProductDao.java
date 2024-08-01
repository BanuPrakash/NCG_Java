package com.adobe.prj.orderapp.dao;

import com.adobe.prj.orderapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    // select * from products where qty = ?
    List<Product> findByQuantity(int qty);

    List<Product> findByPriceBetween(double low, double high);

    List<Product> findByNameLike(String name);

    List<Product> findByNameLikeAndQuantity(String name, int qty);
}
