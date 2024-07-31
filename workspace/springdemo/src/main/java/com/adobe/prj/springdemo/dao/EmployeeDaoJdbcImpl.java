package com.adobe.prj.springdemo.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class EmployeeDaoJdbcImpl  implements  EmployeeDao{
    @Override
    public void addEmployee() {
        System.out.println("stored in database !!!");
    }
}

