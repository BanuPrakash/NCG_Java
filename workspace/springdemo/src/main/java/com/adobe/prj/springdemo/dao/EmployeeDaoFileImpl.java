package com.adobe.prj.springdemo.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class EmployeeDaoFileImpl implements  EmployeeDao{
    @Override
    public void addEmployee() {
        System.out.println("stored in file!!!");
    }
}
