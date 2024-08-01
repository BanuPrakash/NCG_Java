package com.adobe.prj.orderapp.dao;

import com.adobe.prj.orderapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
