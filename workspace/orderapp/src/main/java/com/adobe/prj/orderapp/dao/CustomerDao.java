package com.adobe.prj.orderapp.dao;

import com.adobe.prj.orderapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, String> {
}
