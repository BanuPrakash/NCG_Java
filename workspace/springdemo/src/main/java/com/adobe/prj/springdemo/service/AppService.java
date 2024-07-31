package com.adobe.prj.springdemo.service;

import com.adobe.prj.springdemo.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    @Autowired
    private EmployeeDao employeeDao;

    public void insert() {
        this.employeeDao.addEmployee();
    }
}
