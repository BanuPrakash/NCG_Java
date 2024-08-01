package com.adobe.prj.orderapp.dao;

import com.adobe.prj.orderapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
