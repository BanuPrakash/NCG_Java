package com.adobe.prj.springdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoJdbcImpl  implements  EmployeeDao{
    @Override
    public void addEmployee() {
        System.out.println("stored in database !!!");
    }
}
